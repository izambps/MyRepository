package com.projeto.provadeconhecimento.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.provadeconhecimento.ActivityOficina;
import com.projeto.provadeconhecimento.ClassesDTO.ListaOficinas;
import com.projeto.provadeconhecimento.IndicacaoActivity;
import com.projeto.provadeconhecimento.R;

import java.util.List;

public class AdapterOficinas  extends RecyclerView.Adapter<AdapterOficinas.MyHolder>
{
    private Context context;
    public List<ListaOficinas> listaOficinas;

    public  AdapterOficinas( Context context,List<ListaOficinas> listaOficinas)
    {
        this.context = context;
        this.listaOficinas = listaOficinas;

    }
    public AdapterOficinas(List<ListaOficinas> listaOficinas, Context context)
    {
    }

    @NonNull
    @Override
    public AdapterOficinas.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View oficinas = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.oficinas, viewGroup, false);
        MyHolder viewHolder = new MyHolder(oficinas);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOficinas.MyHolder myHolder, int i)
    {
        try {

           //ListaOficinas dados = listaOficinas.get(i);

            String textoFormato = listaOficinas.get(i).getNome().replace("\\n", System.getProperty("Line.separator"));

            myHolder.Idnome.setText(textoFormato);
            String textoimagem = listaOficinas.get(i).getFoto().replace("\\n", System.getProperty("Line.separator"));
            myHolder.txtimagem = (textoimagem);

            byte[] encodeByte = Base64.decode(myHolder.txtimagem, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

            myHolder.idSlogan.setImageBitmap(bitmap);

            String textoendereco = listaOficinas.get(i).getEndereco().replace("\\n", System.getProperty("Line.separator"));


            myHolder.detalhesBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {
                    Intent intent = new Intent(context, ActivityOficina.class);
                    context.startActivity(intent);
                }

                }
            });


            myHolder.Idendereco.setText(textoendereco);


        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public int getItemCount()
    {
        return listaOficinas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {

        public Button detalhesBotao;
        public TextView Idnome;
        public TextView Idendereco;
        public ImageView idSlogan;
        public TextView Iddescricao;
        public String txtimagem;
        public MyHolder(@NonNull View itemView)
        {
            super(itemView);
            Idnome = itemView.findViewById(R.id.Idnome);
            Idendereco = itemView.findViewById(R.id.Idendereco);
            idSlogan = itemView.findViewById(R.id.idSlogan);
            Iddescricao = itemView.findViewById(R.id.Iddescricao);
            detalhesBotao = itemView.findViewById(R.id.detalhesBotao);

            txtimagem = "";
//            txtimagem = itemView.findViewById(R.id.txtimagem);
//            txtimagem.setVisibility(View.GONE);
        }
    }
}

package com.projeto.provadeconhecimento;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.projeto.provadeconhecimento.Adapters.AdapterOficinas;
import com.projeto.provadeconhecimento.ClassesDTO.Associado;
import com.projeto.provadeconhecimento.ClassesDTO.ListaOficinas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ActivityOficina extends AppCompatActivity {

    private RecyclerView recicleView;
    private Context context;
    private List<ListaOficinas> listaOficinas;
    private ListaOficinas lista;
    private  List<Object> objects;
    private Conexao conexao;
    private  String postParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        recicleView = findViewById(R.id.recicleView);

        conexao = new Conexao();

        iniciarConexao();

    }

    private void iniciarConexao()
    {
        try{

                     // abre a conexao
                     conexao.doInBackground();

                     //lista de string que recebe os dados de retorno
                     ArrayList<String> dados =  new ArrayList<>();
                     dados.add(conexao.lista.toString());


                     listaOficinas = new ArrayList(dados);


                     RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                     AdapterOficinas adapterOficinas = new AdapterOficinas(context, listaOficinas );
                     recicleView.setLayoutManager(layoutManager);
                     recicleView.setAdapter(adapterOficinas);


        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

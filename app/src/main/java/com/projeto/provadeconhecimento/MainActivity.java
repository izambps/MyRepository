package com.projeto.provadeconhecimento;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
    {

    private ImageView oficinasId;
    private ImageView indicacaoId;
    private Button detalhesBotao;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oficinasId =  findViewById(R.id.oficinasId);
        indicacaoId =  findViewById(R.id.indicacaoId);

    }

    public void btnChamarOficinas(View view)
    {
        Intent intent = new Intent(this, ActivityOficina.class);
        startActivity(intent);
    }

    public void btnChamarIndicacao(View view)
    {
        Intent intent = new Intent(this, IndicacaoActivity.class);
        startActivity(intent);
    }



}
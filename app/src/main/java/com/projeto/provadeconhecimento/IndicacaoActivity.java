package com.projeto.provadeconhecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IndicacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicacao);
    }
@Override
public void onBackPressed() {       // ação de voltar do celular
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);

    super.onBackPressed();
}

    public void btnChamarMain(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnChamarIndicacao (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

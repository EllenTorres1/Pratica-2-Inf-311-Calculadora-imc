package com.example.pratica2calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela_2 extends Activity {

    private TextView TxtNome2, TxtIdade2, TxtPeso2, TxtAltura2, TxtImc2, TxtClassificacao2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        TxtNome2 = findViewById(R.id.TxtNome2);
        TxtIdade2 = findViewById(R.id.TxtIdade2);
        TxtPeso2 = findViewById(R.id.TxtPeso2);
        TxtAltura2 = findViewById(R.id.TxtAltura2);
        TxtImc2 = findViewById(R.id.TxtImc2);
        TxtClassificacao2 = findViewById(R.id.TxtClassificacao2);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            String nome = bundle.getString("nome");
            String idade = bundle.getString("idade");
            String peso = bundle.getString("peso");
            String altura = bundle.getString("altura");
            String imc = bundle.getString("imc");
            String classificacao = bundle.getString("classificacao");


            TxtNome2.setText(nome);
            TxtIdade2.setText(idade);
            TxtPeso2.setText(peso);
            TxtAltura2.setText(altura);
            TxtImc2.setText(imc);
            TxtClassificacao2.setText(classificacao);
        }
        Button botaoNovoCalculo = findViewById(R.id.buttonRelatorioNutricional2);
            botaoNovoCalculo.setOnClickListener(view -> {
            Intent intent = new Intent(Tela_2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}



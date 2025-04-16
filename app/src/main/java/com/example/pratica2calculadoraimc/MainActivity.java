package com.example.pratica2calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    private EditText E_Nome, E_Idade, E_Peso, E_Altura;
    private Button Relatorio_Nutricional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        E_Nome = findViewById(R.id.E_Nome);
        E_Altura = findViewById(R.id.E_Altura);
        E_Idade = findViewById(R.id.E_Idade);
        E_Peso = findViewById(R.id.E_Peso);
        Relatorio_Nutricional = findViewById(R.id.buttonRelatorioNutricional);


        Relatorio_Nutricional.setOnClickListener(view -> {

            String Nome = E_Nome.getText().toString();
            String Idade = E_Idade.getText().toString();
            String Peso = E_Peso.getText().toString();
            String Altura = E_Altura.getText().toString();
            double pesoVal = Double.parseDouble(Peso);
            double alturaVal = Double.parseDouble(Altura);
            double imc = pesoVal / (alturaVal * alturaVal);
            DecimalFormat decimalForm = new DecimalFormat("#.00");
            String imcFormatado = decimalForm.format(imc);

            String classificacao;
            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc >= 18.5 && imc <= 24.9) {
                classificacao = "Saudável";
            } else if (imc >= 25 && imc <= 29.9) {
                classificacao = "Sobrepeso";
            } else if (imc >= 30 && imc <= 34.9) {
                classificacao = "Obesidade Grau I";
            } else if (imc >= 35 && imc <= 39.9) {
                classificacao = "Obesidade Grau II (severa)";
            } else {
                classificacao = "Obesidade Grau III (mórbida)";
            }


            Bundle bundle = new Bundle();
            bundle.putString("nome", Nome);
            bundle.putString("idade", Idade);
            bundle.putString("peso", Peso);
            bundle.putString("altura", Altura);
            bundle.putString("imc", imcFormatado);
            bundle.putString("classificacao", classificacao);
            Intent intent = new Intent(MainActivity.this, Tela_2.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}

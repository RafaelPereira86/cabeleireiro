package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView c1 = findViewById(R.id.registar);
        c1.setOnClickListener(v -> handleCardViewSelection(1));

        CardView c2 = findViewById(R.id.pesquisar);
        c2.setOnClickListener(v -> handleCardViewSelection(2));

    }
    private void handleCardViewSelection(int selection) {
        Intent intent;

        switch (selection) {
            case 1:
                // Ação para a primeira opção
                intent = new Intent(this,Registar.class);
                startActivity(intent);
                break;
            case 2:
                // Ação para a segunda opção
                intent = new Intent(this, Pesquisar.class);
                startActivity(intent);
                break;
            // Adicione mais casos para outras opções
            default:
                // Ação padrão (se necessário)
                break;
        }
    }
}





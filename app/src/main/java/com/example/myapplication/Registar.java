package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registar extends AppCompatActivity {

    EditText nome;
    EditText numeroTelemovel;
    EditText dataNascimento;
    Button btn;
    DB_handler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        db = new DB_handler(this,"DB_handler",null,1);
        nome = findViewById(R.id.editNome);
        numeroTelemovel = findViewById(R.id.editNumeroTele);
        dataNascimento = findViewById(R.id.editTextData);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter valores dos EditTexts
                String nomeText = nome.getText().toString();
                String numeroTelemovelText = numeroTelemovel.getText().toString();
                String dataNascimentoText = dataNascimento.getText().toString();

                // Verificar se os campos obrigatórios foram preenchidos
                if (!nomeText.isEmpty() && !numeroTelemovelText.isEmpty() && !dataNascimentoText.isEmpty()) {
                    // Criar um novo cliente com as informações desejadas
                    Cliente nCliente = new Cliente(numeroTelemovelText, nomeText, dataNascimentoText, "", "", "", "","");

                    // Definir informações opcionais
                    nCliente.setDia(null);
                    nCliente.setCor(null);
                    nCliente.setGrama(null);
                    nCliente.setVolume(null);
                    nCliente.setProdAdq(null);

                    // Adicionar o novo cliente à base de dados
                    db.addCliente(nCliente);
                    Log.d("Registar", "Cliente criado com sucesso: " + nCliente.toString());

                    // Exibir um Toast indicando que o cliente foi criado com sucesso
                    Toast.makeText(Registar.this, "Cliente criado com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Registar.this, MainActivity.class);
                    startActivity(intent);
                    finish(); //
                } else {
                    // Exibir um Toast indicando que todos os campos obrigatórios devem ser preenchidos
                    Toast.makeText(Registar.this, "Preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

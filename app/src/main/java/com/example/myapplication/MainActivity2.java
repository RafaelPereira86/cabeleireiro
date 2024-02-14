package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity2 extends AppCompatActivity {

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        criarBaseDados();
        listarDados();

        Handler handler = new Handler();
        long attrs = 4000;
        handler.postDelayed(() -> {
            startActivities(new Intent[]{new Intent(MainActivity2.this, MainActivity.class)});
            finish();
        },attrs);
    }

    public void criarBaseDados(){
        try {
            database = openOrCreateDatabase("cbapp",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS cliente("+
                    "ntele INTERGER PRIMARY KEY" +
                    ", nome VARCHAR" +
                    ", cor VARCHAR" +
                    ", volume INTERGER" +
                    ",ns VARCHAR " +
                    ", prod_Adq VARCHAR)");
            database.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listarDados(){

    }
}
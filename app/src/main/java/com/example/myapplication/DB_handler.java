package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_handler extends SQLiteOpenHelper {

    Context context;
    //DEFINICOES BASE DE DADODS
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cb_db";

    //NOME DAS TABELAS
    public static final String DB_CL_TABLE = "CL";

    //TABELA CLIENTE
    public static final String CLNOME = "CLNOME";
    public static final String CLDATANASCIMENTO = "CLDATANASCIMENTO";
    public static final String CLNTELEMOVEL = "CLNTELEMOVEL";
    public static final String CLDIA = "CLDIA";
    public static final String CLCOR = "CLCLIENTE";
    public static final String CLGRAMA = "CLGRAMA";
    public static final String CLVOLUME = "CLVOLUME";
    //produtos adquiridos
    public static final String CLPRODADQ = "CLPRODADQ";

    public DB_handler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTabelaCl = String.format("CREATE TABLE %s(%s INTERGER PRIMARY KEY,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT)", DB_CL_TABLE,CLNTELEMOVEL,CLNOME,CLDATANASCIMENTO,CLDIA,CLCOR,CLGRAMA,CLVOLUME,CLPRODADQ);
        db.execSQL(queryTabelaCl);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_CL_TABLE);
        onCreate(db);
    }
    public void addCliente(Cliente c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryAdd = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s) VALUES (%s,%s,%s,%s,%s,%s,%s,%s); ", DB_CL_TABLE,CLNTELEMOVEL,CLNOME,CLDATANASCIMENTO,CLDIA,CLCOR,CLGRAMA,CLVOLUME,CLPRODADQ, c.getnTelemovel(), c.getNome(),c.getDataNascimento(),c.getDia(),c.getCor(),c.getGrama(),c.getVolume(),c.getProdAdq());
        db.execSQL(queryAdd);
    }

    public void updateCliente(Cliente c) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryUpdate = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s='%s';",
                DB_CL_TABLE,
                CLNOME, c.getNome(),
                CLDATANASCIMENTO, c.getDataNascimento(),
                CLDIA, c.getDia(),
                CLCOR, c.getCor(),
                CLGRAMA, c.getGrama(),
                CLVOLUME, c.getVolume(),
                CLPRODADQ, c.getProdAdq(),
                CLNTELEMOVEL, c.getnTelemovel());

        db.execSQL(queryUpdate);
        db.close();
    }

    public void deleteCliente(String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        String queryDelete = String.format("DELETE FROM %s WHERE %s='%s';",
                DB_CL_TABLE,
                CLNTELEMOVEL, phoneNumber);

        db.execSQL(queryDelete);
        db.close();
    }

}

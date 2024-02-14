package com.example.myapplication;

import android.widget.EditText;
public class Cliente {
    private String nTelemovel;
    private String nome;
    private String dataNascimento;
    private String dia;
    private String cor;
    private String grama;
    private String volume;
    private String prodAdq;

    public Cliente( String nTelemovel, String nome, String dataNascimento, String dia, String cor, String grama, String volume, String prodAdq) {

        this.nTelemovel = nTelemovel;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dia = dia;
        this.cor = cor;
        this.grama = grama;
        this.volume = volume;
        this.prodAdq = prodAdq;
    }



    public String getnTelemovel() {
        return nTelemovel;
    }

    public void setnTelemovel(String nTelemovel) {
        this.nTelemovel = nTelemovel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getGrama() {
        return grama;
    }

    public void setGrama(String grama) {
        this.grama = grama;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getProdAdq() {
        return prodAdq;
    }

    public void setProdAdq(String prodAdq) {
        this.prodAdq = prodAdq;
    }
}

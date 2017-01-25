package br.com.devmarques.bltnotas.notas.classnotas;

import java.io.Serializable;

/**
 * Created by Roger on 09/01/2017.
 */

public class Dadosnotas implements Serializable {

    private long id;
    private String Nomemateria, QtdsNotas;
    private double Valornota,Valornota2,Valornota3,Valornota4;
    private double peso, peso2,peso3, peso4;
    private double media , maxima;
    private double resultado;

    public Dadosnotas() {

    }

    public Dadosnotas(String nomemateria, double valornota, double valornota2, double valornota3, double valornota4, double peso, double peso2, double peso3, double peso4, double media, double maxima, double resultado) {
        Nomemateria = nomemateria;
        Valornota = valornota;
        Valornota2 = valornota2;
        Valornota3 = valornota3;
        Valornota4 = valornota4;
        this.peso = peso;
        this.peso2 = peso2;
        this.peso3 = peso3;
        this.peso4 = peso4;
        this.media = media;
        this.maxima = maxima;
        this.resultado = resultado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomemateria() {
        return Nomemateria;
    }

    public void setNomemateria(String nomemateria) {
        Nomemateria = nomemateria;
    }

    public double getValornota() {
        return Valornota;
    }

    public void setValornota(double valornota) {
        Valornota = valornota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getValornota2() {
        return Valornota2;
    }

    public double getValornota3() {
        return Valornota3;
    }

    public double getValornota4() {
        return Valornota4;
    }

    public double getPeso2() {
        return peso2;
    }

    public double getPeso3() {
        return peso3;
    }

    public double getPeso4() {
        return peso4;
    }

    public void setValornota3(double valornota3) {
        Valornota3 = valornota3;
    }

    public void setValornota2(double valornota2) {
        Valornota2 = valornota2;
    }

    public void setValornota4(double valornota4) {
        Valornota4 = valornota4;
    }

    public void setPeso2(double peso2) {
        this.peso2 = peso2;
    }

    public void setPeso3(double peso3) {
        this.peso3 = peso3;
    }

    public void setPeso4(double peso4) {
        this.peso4 = peso4;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMaxima() {
        return maxima;
    }

    public void setMaxima(double maxima) {
        this.maxima = maxima;
    }

    public String getQtdsNotas() {
        return QtdsNotas;
    }

    public void setQtdsNotas(String qtdsNotas) {
        QtdsNotas = qtdsNotas;
    }
}

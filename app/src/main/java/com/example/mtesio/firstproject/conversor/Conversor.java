package com.example.mtesio.firstproject.conversor;

public class Conversor {

    private double millas;
    private double kilometros;

    public void convertir(){
        kilometros = millas * 1.6;
    }

    public double getMillas() {
        return millas;
    }

    public void setMillas(double millas) {
        this.millas = millas;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }
}

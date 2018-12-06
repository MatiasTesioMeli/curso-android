package com.example.mtesio.firstproject.conversor;

public class Conversor {

    private final double MILLAS_A_KILOMETROS_MULPIPLIER = 1.6;

    private double millas;
    private double kilometros;

    public void convertir(){
        kilometros = millas * MILLAS_A_KILOMETROS_MULPIPLIER;
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

}

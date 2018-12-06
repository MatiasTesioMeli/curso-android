package com.example.mtesio.firstproject;

import com.example.mtesio.firstproject.conversor.Conversor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConversorTests {

    @Test
    public void convertirIsOKWhenPassedMillesEqualsOne() {
        Conversor conv = new Conversor();
        conv.setMillas(1);
        conv.convertir();
        assertEquals(1.6, conv.getKilometros(), 0.001);
    }

}

package com.example.proyectoinventario2.jUnitRepaso;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class AssertNotEqualsTest {

    @Test
    public void miTest(){
        assertNotEquals("Hola","Hol");
    }
}

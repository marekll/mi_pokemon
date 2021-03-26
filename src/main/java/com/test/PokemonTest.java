package com.test;
import com.company.Pokemon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonTest {
    @Test
    public void testDomino() {
        assertEquals(Pokemon.getEfficiency("fire -> grass"), "2x");
        assertEquals(Pokemon.getEfficiency("fighting -> ice rock"), "4x");
        assertEquals(Pokemon.getEfficiency("psychic -> poison dark"), "0x");
        assertEquals(Pokemon.getEfficiency("water -> normal"), "1x");
        assertEquals(Pokemon.getEfficiency("fire -> rock"), "0.5x");


    }
}

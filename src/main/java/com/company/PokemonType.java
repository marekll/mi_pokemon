package com.company;

import javafx.util.Pair;

public class PokemonType {
    String name;
    String url;
    @Override
    public boolean equals(Object o){
        return this.name.equals(((PokemonType) o).getName());
    }
    public String getName(){
        return name;
    }
}

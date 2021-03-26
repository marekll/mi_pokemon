package com.company;

import java.util.ArrayList;

public class DamageRelations {
    ArrayList<PokemonType> double_damage_to;
    ArrayList<PokemonType> half_damage_to;
    ArrayList<PokemonType> no_damage_to;

    public String getEffinciencyTo(String rivals){
        double efficiency = 1d;
        String[] rivals_arr = rivals.split(" ");
        efficiency *= getEffSinglelist(double_damage_to, rivals_arr, 2d);
        efficiency *= getEffSinglelist(half_damage_to, rivals_arr, 0.5);
        efficiency *= getEffSinglelist(no_damage_to, rivals_arr, 0d);
        if(efficiency<1d && efficiency>0d) {
            return efficiency + "x";
        }
        return (int)efficiency + "x";
    }
    private double getEffSinglelist(ArrayList<PokemonType> list, String[] rivals_arr, double wsp){
        double efficiency = 1d;
        for(PokemonType pokemonType: list){
            for(String rival: rivals_arr) {
                if (pokemonType.getName().equals(rival)){
                    efficiency *= wsp;
                }
            }
        }
        return efficiency;
    }
}

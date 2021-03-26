package com.company;

public class PokemonTypeWrapper {
    transient String name;
    DamageRelations damage_relations;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    protected String getEfficiency(String type){
        return damage_relations.getEffinciencyTo(type);
    }
}

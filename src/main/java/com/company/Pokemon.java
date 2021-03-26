package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import com.google.gson.Gson;

public class Pokemon {
    private static LinkedList<PokemonTypeWrapper> pokemonTypes = new LinkedList<PokemonTypeWrapper>();
    public static String getEfficiency(String types) {
        PokemonTypeWrapper ptw = new PokemonTypeWrapper();
        String[] types_arr = types.split("->");
        String type1 = types_arr[0].trim();
        String type2 = types_arr[1];
        boolean is_in_list = false;
        for(PokemonTypeWrapper pokemonTypeWrapper: pokemonTypes) {
            if(type1.equals(pokemonTypeWrapper.getName())){
                ptw = pokemonTypeWrapper;
                is_in_list = true;
            }
        }
        if (!is_in_list){
            try {
                URL url = new URL("https://pokeapi.co/api/v2/type/" + type1);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                        "(KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
                connection.connect();
                System.out.println(connection.getResponseMessage());
                Gson gson = new Gson();
                ptw = gson.fromJson(new InputStreamReader(connection.getInputStream()), PokemonTypeWrapper.class);
                ptw.setName(type1);
                pokemonTypes.add(ptw);
                System.out.println(ptw.damage_relations);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return ptw.getEffinciency(type2);

    }
}

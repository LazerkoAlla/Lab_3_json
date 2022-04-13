package com.core;

import com.domain.Software;
import com.domain.Stuff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonExample2 {

    public static void main(String[] args) {

        //Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT )
                //.create();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT )
                .create();

        try (Reader reader = new FileReader("json/student.json")) {

            // Convert JSON File to Java Object
            //Stuff stuff = gson.fromJson(reader, Stuff.class);


            Type collectionType = new TypeToken<List<Stuff>>(){}.getType();
List<Stuff> stuff = (List<Stuff>) new Gson().fromJson(reader, collectionType);

            System.out.println(stuff);


            // print staff
            //System.out.println(stuff.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
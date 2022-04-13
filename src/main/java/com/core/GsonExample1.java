package com.core;

import com.domain.Stuff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT )
                .create();

        ArrayList<Stuff> stuffs = createStuffObject();

        String json = gson.toJson(stuffs);




        try (FileWriter writer = new FileWriter("json/student.json")) {
            gson.toJson(stuffs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static ArrayList<Stuff> createStuffObject() {

        Stuff stuff = new Stuff();
        Stuff stuff1 = new Stuff();
        ArrayList<Stuff> arr = new ArrayList<>();


        stuff.setName("oleg");
        stuff.setAge(35);
        stuff.setPosition(Arrays.asList("Founder", "SEO", "coder"));
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2014", new BigDecimal(14000));
        }};

        stuff.setSalary(salary);
        stuff.setSkills(Arrays.asList("java", "python", "node", "c++"));

        stuff1.setName("Masha");
        stuff1.setAge(28);
        stuff1.setPosition(Arrays.asList("developer", "front-end", "coder"));
        Map<String, BigDecimal> salary1 = new HashMap() {{
            put("2010", new BigDecimal(10));
            put("2012", new BigDecimal(12));
            put("2014", new BigDecimal(140));
        }};
        stuff1.setSalary(salary1);
        stuff1.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        arr.add(stuff);
        arr.add(stuff1);

        return arr;

    }
    /**private static Stuff createStaffObject1() {


        Stuff stuff1 = new Stuff();
        stuff1.setName("Masha");
        stuff1.setAge(28);
        stuff1.setPosition(new String[]{"F", "S", "c"});
        Map<String, BigDecimal> salary1 = new HashMap() {{
            put("2010", new BigDecimal(10));
            put("2012", new BigDecimal(12));
            put("2014", new BigDecimal(140));
        }};
        stuff1.setSalary(salary1);
        stuff1.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return stuff1;

    }**/


}


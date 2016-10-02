package fr.fhacktory.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NameGenerator {

    private static final List<String> names = Arrays.asList("Haud", "Servane", "Nancy", "Laure", "Sarah", "Dominique",
	    "Estelle", "Agnès", "Nathou", "Cécile", "Kevina");
    
    
    public static String getAName(){
	Random rand = new Random();
	return names.get(rand.nextInt(names.size()));
    }

}

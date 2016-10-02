package fr.fhacktory.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

/**
 * 
 * @author mohamed.yengui
 *
 */
@UtilityClass
public class PlaceGenerator {

    private static final List<String> places = Arrays.asList("plage", "ville", "théâtre", "musée", "Inde", "Nid du Tigre", "grotte aux cristaux", "Salto del Angel", "montagne","île", "océan", "falaise", "Église", "Château", "Parc forestier" , "Dark Alley", "champs de tulipes");

    public static String getPlace(){
	Random rand = new Random();
	return places.get(rand.nextInt(places.size()));
    }
}

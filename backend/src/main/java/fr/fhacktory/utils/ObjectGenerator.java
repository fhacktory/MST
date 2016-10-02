package fr.fhacktory.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectGenerator {

    private static final List<String> objects = Arrays.asList("glace", "téléphone", "jus", "banane", "baby foot",
	    "souris", "fleurs", "cerises", " diamant", "dragon", "mirroir", "Avion", "Ballon", "Bateau",
	    "Brosse à dent", "Camion", "Camion pompier", "Canapé", "Ceinture", "Chaise", "Chaussette", "Cheminée",
	    "Cirque", "Ciseau", "Coffre-fort", "Disque", "Distributeur", "Drap", "Flipper", "Fourchette", "Frigo",
	    "Igloo", "Jeu de cartes", "Lampe", "Lit", "Maison", "Mer", "Montagne", "Neige", "Ordinateur",
	    "Porte-monnaie", "Poubelle", "Prise éléctrique", "Raquette", "Slip", "Stylo", "Table", "Tam-tam",
	    "Tablette tactile", "Tee-shirt", "Télécommande", "Téléphone", "Télévision", "Tour Eiffel", "Valise",
	    "Voiture", "Walkman");

    public static String getAnObject() {
	Random rand = new Random();
	return objects.get(rand.nextInt(objects.size()));
    }
}

package fr.fhacktory.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectGenerator {

	private static final List<String> objects = Arrays.asList("glace", "téléphone", "jus", "banane", "baby foot",
			"souris", "fleurs", "cerises", " diamant", "dragon", "mirroir");

	public static String getAnObject() {
		Random rand = new Random();
		return objects.get(rand.nextInt(objects.size()));
	}
}

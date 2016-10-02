package fr.fhacktory.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

/**
 * Generate a random adjective
 *
 * @author mohamed.yengui
 *
 */
@UtilityClass
public class AdjectifsGenerator {

	private static final List<String> adjectifs = Arrays.asList("Absolu", "Admirable", "Agréable", "Aimable", "Amusant",
			"Apocalyptique", "Approximatif", "Attachant", "Banal", "Bas", "Bavarois", "Bien", "Bof", "Bon",
			"Bouleversant", "Boute-en-train", "Captivant", "Caractériel", "Cataclysmique", "Catastrophique", "Céleste",
			"Charmant", "Chef-d’œuvre", "Chouette", "Commun", "convenable", "Convivial", "Coquet", "Correct",
			"Crédible", "Croquante", "Cynique", "Dégueulasse", "Délectable", "Délicieuse", "Disjoncté", "Divin",
			"Douce", "Doué", "Drôle", "Éblouissant", "Ébouriffé", "Efficace", "Emballant", "Émouvant", "Endiablé",
			"Ennuyant", "Enragé", "Enthousiasmant", "Épatant", "Époustouflant", "Épouvantable", "Équitable", "Exaltant",
			"Exceptionnel", "Excusable", "Exemplaire", "Extramoelleux", "Féru", "Festif", "Flamboyante", "Formidable",
			"Grandiose", "Hardi", "Honnête", "Horrible", "Important", "Impressionnant", "Inconnu", "Incrédule",
			"Indépendant", "Infernal", "Innommable", "Insignifiant", "Insuffisant", "Insupportable", "Intenable",
			"Intéressant", "Irrésistible", "Libidineux", "Louable", "Majestueux", "Magistral", "Magnifique", "Médiocre",
			"Merdique", "Merveilleux", "Mignon", "Minable", "Mirobolante", "Mortel", "Moyen", "Négligeable", "Nul",
			"Ordinaire", "Original", "Parfait", "Paspire", "Passable", "Passionnant", "Percutant", "Persévérant",
			"Phénoménal", "Placide", "Plaisant", "Prestant", "Prodigieux", "Proverbial", "Quelconque", "Ravissant",
			"Recyclé", "Relatif", "Remarquable", "Renversant", "Revendicatrice", "Révolutionnaire", "Rocambolesque",
			"Rutilant", "Saint", "Satisfaisant", "Séduisant", "Sexy", "Somptueux", "Spiritueux", "Splendide", "Suave",
			"Sublime", "Sulfureuse", "Superbe", "Suprême", "Supportable", "Talentueux", "Tolérable", "Tragique",
			"Trépidant", "Trèsbon", "Troublant", "Valable", "Valeureux", "Vénérable", "Vitaminés", "Vivable",
			"Vulgaire");

	public static String getAnAdjectif() {
		Random rand = new Random();
		return adjectifs.get(rand.nextInt(adjectifs.size())).toLowerCase();
	}
}

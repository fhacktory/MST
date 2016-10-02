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
	    "Charmant", "Chouette", "Commun", "convenable", "Convivial", "Coquet", "Correct", "Crédible", "Croquante",
	    "Cynique", "Délectable", "Délicieuse", "Disjoncté", "Divin", "Douce", "Doué", "Drôle", "Éblouissant",
	    "Ébouriffé", "Efficace", "Emballant", "Émouvant", "Endiablé", "Ennuyant", "Enragé", "Enthousiasmant",
	    "Épatant", "Époustouflant", "Épouvantable", "Équitable", "Exaltant", "Exceptionnel", "Excusable",
	    "Exemplaire", "Extramoelleux", "Féru", "Festif", "Flamboyante", "Formidable", "Grandiose", "Hardi",
	    "Honnête", "Horrible", "Important", "Impressionnant", "Inconnu", "Incrédule", "Indépendant", "Infernal",
	    "Innommable", "Insignifiant", "Insuffisant", "Insupportable", "Intenable", "Intéressant", "Irrésistible",
	    "Louable", "Majestueux", "Magistral", "Magnifique", "Médiocre", "Merdique", "Merveilleux", "Mignon",
	    "Minable", "Mirobolante", "Mortel", "Moyen", "Négligeable", "Nul", "Ordinaire", "Original", "Parfait",
	    "Paspire", "Passable", "Passionnant", "Percutant", "Persévérant", "Phénoménal", "Placide", "Plaisant",
	    "Prestant", "Prodigieux", "Proverbial", "Quelconque", "Ravissant", "Recyclé", "Relatif", "Remarquable",
	    "Renversant", "Revendicatrice", "Révolutionnaire", "Rocambolesque", "Rutilant", "Saint", "Satisfaisant",
	    "Séduisant", "Sexy", "Somptueux", "Spiritueux", "Splendide", "Suave", "Sublime", "Superbe", "Suprême",
	    "Supportable", "Talentueux", "Tolérable", "Tragique", "Trépidant", "Très bon", "Troublant", "Valable",
	    "Valeureux", "Vénérable", "Vitaminés", "Vivable");

    private static final List<String> personsAdj = Arrays.asList("Admirable", "Agréable", "Aimable", "Amusant",
	    "Attachant", "Banal", "Bas", "Bavarois", "Bon", "Captivant", "Caractériel", "Charmant", "Chouette",
	    "Convivial", "Coquet", "Correct", "Crédible", "Croquante", "Cynique", "Délectable", "Délicieuse",
	    "Disjoncté", "Divin", "Douce", "Doué", "Drôle", "Éblouissant", "Efficace", "Emballant", "Émouvant",
	    "Endiablé", "Ennuyant", "Enragé", "Enthousiasmant", "Épatant", "Époustouflant", "Épouvantable", "Exaltant",
	    "Exceptionnel", "Exemplaire", "Festif", "Flamboyante", "Formidable", "Hardi", "Honnête", "Horrible",
	    "Important", "Impressionnant", "Incrédule", "Infernal", "Insignifiant", "Insupportable", "Intenable",
	    "Intéressant", "Irrésistible", "Majestueux", "Magistral", "Magnifique", "Médiocre", "Merdique",
	    "Merveilleux", "Mignon", "Minable", "Mirobolante", "Mortel", "Ordinaire", "Original", "Parfait", "Passable",
	    "Passionnant", "Percutant", "Persévérant", "Phénoménal", "Plaisant", "Prodigieux", "Quelconque",
	    "Ravissant", "Remarquable", "Renversant", "Revendicatrice", "Révolutionnaire", "Rocambolesque", "Rutilant",
	    "Saint", "Séduisant", "Sexy", "Somptueux", "Spiritueux", "Splendide", "Suave", "Sublime", "Superbe",
	    "Suprême", "Supportable", "Talentueux", "Tolérable", "Trépidant", "Très bon", "Valeureux", "Vénérable",
	    "Vivable", "accueillant", "adorable", "alourdi", "bien attifé", "mal attifé", "attrayant", "beau", "carré",
	    "confiant", "costaud", "crasseux", "désillusionné", "droit", "dynamique", "élégant", "bien élevé",
	    "mal élevé", "énervé", "gai", "gentil ", "grand", "gros", "bien habillé", "mal habillé", "hideux",
	    "hirsute", "inquiet", "magnifique", "maigre", "maladroit", "merveilleux", "mince", "nerveux", "offensé",
	    "parfait", "plaisant", "propre", "qui donne la chair de poule", "ravissant", "réfléchi", "sale", "sauvage",
	    "séduisant", "snob", "sombre", "souriant", "splendide", "svelte", "tendu", "terne", "fade", "timide",
	    "trompeur ", "vif", "vivace");

    // private static final List<String> personalityAdj =
    // Arrays.asList("agressif", "ambitieux", "amusé", "avare", "brave",
    // "brillant", "calme", "chaleureux", "combatif", "coopératif", "cruel",
    // "dangereux", "débile", "désagréable",
    // "déterminé", "diligent", "dominant", "doué", "égoïste", "entraînant",
    // "farfelu", "fatigant", "fourbe",
    // "franc franche", "généreux", "harmonieux", "hésitant ", "hypocrite",
    // "impartial", "bien informé",
    // "instinctif", "intrépide ", "jaloux", "lâche ", "loufoque", "mauvais ",
    // "mystérieux", "placide",
    // "plaisant ", "ponctuel", "posé", "protecteur", "qui a du succès",
    // "regardant", "sage", "scélérat",
    // "serviable", "sincère", "solitaire", "spirituel", "talentueux",
    // "truculent", "vilain", "vorace");

    private static final List<String> objectsAdj = Arrays.asList("argenté", "azuré ", "blanc", "bleu ", "blond", "brun",
	    "châtain féminin pluriel", "cyan ", "grenat", "magenta", "marron", "noir ", "orange", "pourpré", "rose ",
	    "roux", "turquoise", "vert ", "violet", "colossal", "considérable", "énorme", "exigu exiguë", "fin",
	    "gigantesque", "grand ", "immense", "important", "imposant", "infime", "large ", "menu", "minuscule ",
	    "monumental", "petit ", "spacieux", "super féminin", "vaste", "altéré ", "carré ", "circulaire ", "creux",
	    "décomposé", "déformé", "droit", "étroit ", "géométrique", "large ", "long longue", "maigre ", "plat ",
	    "primitif", "raide ", "rectangulaire", "rond", "simple", "tordu ", "triangulaire", "vaste", "abondant",
	    "bienfaisant", "chargé", "compact", "considérable", "dense", "écrasant", "énorme", "extra féminin",
	    "fréquent", "généreux", "gros", "illimité", "incalculable", "innombrable", "léger", "lourd", "multiple",
	    "nombreux", "rempli", "substantiel", "répété", "vide", "volumineux");

    public static String getAnAdjectif() {
	Random rand = new Random();
	return adjectifs.get(rand.nextInt(adjectifs.size())).toLowerCase();
    }

    public static String getAPersonAdjectif() {
	Random rand = new Random();
	return personsAdj.get(rand.nextInt(personsAdj.size())).toLowerCase();
    }

    public static String getAnObjectAdjectif() {
	Random rand = new Random();
	return objectsAdj.get(rand.nextInt(objectsAdj.size())).toLowerCase();
    }

}

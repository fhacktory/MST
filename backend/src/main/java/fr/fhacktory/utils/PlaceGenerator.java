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

	private static final List<String> places = Arrays.asList("plage", "ville", "théâtre", "musée", "Inde",
			"Nid du Tigre", "grotte aux cristaux", "Forêt", "Aréna", "Église", "Automobile", "Métro", "Avion",
			"Salle de spectacle", "Garage", "Jungle", "Cimetière", "Île déserte", "Pôle Nord", "Désert", "Hôtel",
			"Cuisine", "Chalet", "Pays étranger", "Cabane à sucre", "Salon", "Salle de bal", "Saloon", "Bateau",
			"Château", "Ferme", "Salle de bain", "Restaurant", "Bureau", "Salle de presse", "Autobus", "Sous-marin",
			"Limousine", "Jardin", "Parlement", "Espace", "Parc d’attraction", "Dortoir", "Gymnase",
			"Salle d’entraînement", "Enfer", "Stationnement", "Ruelle", "Usine", "Ascenseur", "Garde robe", "Piscine",
			"Bibliothèque", "Hôtel de ville", "Salon de coiffure", "Banque", "Autoroute", "Aéroport", "Hôpital",
			"Chambre à coucher", "Plage", "Camp militaire", "Bar", "École", "Garderie", "Prison", "Vaisseau spatial",
			"Paradis", "Grotte", "Centre commercial", "Salon de bronzage", "Arcade", "Salle d’attente",
			"Toilette publique", "Fumoir", "Salon de quilles", "Club vidéo", "montagne", "île", "océan", "falaise",
			"Église", "Château", "Parc forestier", "Dark Alley", "champs de tulipes");

	public static String getPlace() {
		Random rand = new Random();
		return places.get(rand.nextInt(places.size())).toLowerCase();
	}
}

package fr.fhacktory.utils;

import java.util.ArrayList;
import java.util.List;

import fr.fhacktory.data.service.WikidataFetcher;
import org.apache.commons.lang3.StringUtils;

import fr.fhacktory.model.Sentence;
import fr.fhacktory.model.StepForm;
import fr.fhacktory.model.Story;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.CoordinatedPhraseElement;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.french.XMLLexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.PPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.Realiser;

@UtilityClass
@Slf4j
public class SentenceGenerator {

	static public Lexicon lexicon = new XMLLexicon();
	static public NLGFactory nlgFactory = new NLGFactory(lexicon);
	static public Realiser realiser = new Realiser();

	public static List<Sentence> generateSentence(StepForm questionnaire, Story currentStory) {
		log.debug(questionnaire.toString());
		List<Sentence> sentenceList = new ArrayList<>();
		try {
			for (int i = 0; i < 2; i++) {
				sentenceList.add(generateOneSentence(questionnaire, currentStory));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return sentenceList;
	}

	/**
	 * @param questionnaire
	 * @param sentenceList
	 */
	private static Sentence generateOneSentence(StepForm questionnaire, Story currentStory) {
		Sentence sentence = new Sentence(questionnaire, currentStory);

		sentence.setGeneratedSentence(sentenceToPhrase(sentence, currentStory));
		log.debug(sentence.getGeneratedSentence());

		WikidataFetcher.retrieveImageForSentence(sentence);

		return sentence;
	}

	/**
	 * @param sentence
	 * @return
	 */
	public static String sentenceToPhrase(Sentence sentence, Story currentStory) {
		SPhraseSpec ilEtaitUneFois = null;
		if (currentStory == null || currentStory.getSentences() == null || currentStory.getSentences().isEmpty()) {
			// Il était une fois
			NPPhraseSpec unFois = nlgFactory.createNounPhrase("un", "fois");
			ilEtaitUneFois = nlgFactory.createClause("il", "être", unFois);
			ilEtaitUneFois.setFeature(Feature.TENSE, Tense.PAST);
			ilEtaitUneFois.setFeature(Feature.PROGRESSIVE, true);
			ilEtaitUneFois.setFeature(Feature.PERFECT, false);
		}

		NPPhraseSpec sujet = nlgFactory.createNounPhrase(sentence.getSubject());

		NPPhraseSpec complement = nlgFactory.createNounPhrase(Math.random() < 0.6 ? "le" : "un",
				sentence.getComplement());
		if (Math.random() < 0.2) {
			complement.setPlural(true);
		}
		// Ajout d'un adjectif au complément
		if (StringUtils.isNotBlank(sentence.getAdjectivComplement())) {
			complement.addModifier(sentence.getAdjectivComplement());
		}

		// Ajout d'un adjectif au complément
		NPPhraseSpec place = nlgFactory.createNounPhrase(Math.random() < 0.6 ? "le" : "un", sentence.getPlace());
		if (StringUtils.isNotBlank(sentence.getAdjectivPlace())) {
			place.addModifier(sentence.getAdjectivPlace());
		}

		String verb = sentence.getVerb();

		PPPhraseSpec dansLieux = nlgFactory
				.createPrepositionPhrase(Math.random() < 0.4 ? "dans" : Math.random() < 0.4 ? "sur" : "vers", place);

		SPhraseSpec phrase = nlgFactory.createClause(sujet, verb, complement);

		if (Math.random() < 0.05) {
			phrase.setFeature(Feature.NEGATED, true);
		}

		phrase.setComplement(dansLieux);
		// Temps : Imparfait
		phrase.setFeature(Feature.TENSE, Tense.PAST);
		phrase.setFeature(Feature.PROGRESSIVE, true);
		phrase.setFeature(Feature.PERFECT, false);

		if (ilEtaitUneFois != null) {
			CoordinatedPhraseElement coordinatedPhrase = nlgFactory.createCoordinatedPhrase(ilEtaitUneFois, phrase);
			return realiser.realiseSentence(coordinatedPhrase);
		} else {
			String stSentence = realiser.realiseSentence(phrase);
			return stSentence;
		}
	}

}

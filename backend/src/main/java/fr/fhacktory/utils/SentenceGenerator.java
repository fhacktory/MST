package fr.fhacktory.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.fhacktory.model.Sentence;
import fr.fhacktory.model.StepForm;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import simplenlg.features.Feature;
import simplenlg.features.Tense;
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

	public static List<Sentence> generateSentence(StepForm questionnaire) {
		log.debug(questionnaire.toString());
		List<Sentence> sentenceList = new ArrayList<>();
		try {
			for (int i = 0; i < 2; i++) {
				sentenceList.add(generateOneSentence(questionnaire));
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
	private static Sentence generateOneSentence(StepForm questionnaire) {
		Sentence sentence = new Sentence(questionnaire);

		sentence.setGeneratedSentence(sentenceToPhrase(sentence));
		log.debug(sentence.getGeneratedSentence());

		return sentence;
	}

	/**
	 * @param sentence
	 * @return
	 */
	private static String sentenceToPhrase(Sentence sentence) {
		NPPhraseSpec sujet = nlgFactory.createNounPhrase(sentence.getSubject());

		NPPhraseSpec complement = nlgFactory.createNounPhrase("le", sentence.getComplement());
		// Ajout d'un adjectif au complément
		if (StringUtils.isNotBlank(sentence.getAdjectivComplement())) {
			complement.addModifier(sentence.getAdjectivComplement());
		}

		// Ajout d'un adjectif au complément
		NPPhraseSpec place = nlgFactory.createNounPhrase("le", sentence.getPlace());
		if (StringUtils.isNotBlank(sentence.getAdjectivPlace())) {
			place.addModifier(sentence.getAdjectivPlace());
		}

		String verb = sentence.getVerb();

		// PPPhraseSpec complementDuNomMatiere =
		// nlgFactory.createPrepositionPhrase("en", "pierre");
		// lieu.addModifier(complementDuNomMatiere);

		PPPhraseSpec dansLieux = nlgFactory.createPrepositionPhrase("dans", place);

		SPhraseSpec phrase = nlgFactory.createClause(sujet, verb, complement);
		phrase.setComplement(dansLieux);
		phrase.setFeature(Feature.TENSE, Tense.PAST);
		String stSentence = realiser.realiseSentence(phrase);
		return stSentence;
	}

}

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
		Sentence sentence = new Sentence();
		NPPhraseSpec sujet;
		if (StringUtils.isBlank(questionnaire.getSubject())) {
			sujet = nlgFactory.createNounPhrase("Cédric");

		} else {
			sujet = nlgFactory.createNounPhrase(questionnaire.getSubject());
		}
		NPPhraseSpec complement;
		if (StringUtils.isBlank(questionnaire.getComplement())) {
			complement = nlgFactory.createNounPhrase("un", "glace");

		} else {
			complement = nlgFactory.createNounPhrase("le", questionnaire.getComplement());
		}
		// Ajout d'un adjectif au complément
		String adjectif = AdjectifsGenerator.getAnAdjectif();
		complement.addModifier(adjectif);

		NPPhraseSpec lieu;
		if (StringUtils.isBlank(questionnaire.getPlace())) {
			lieu = nlgFactory.createNounPhrase("le", PlaceGenerator.getPlace());

		} else {
			lieu = nlgFactory.createNounPhrase("le", questionnaire.getPlace());
		}
		// Ajout d'un adjectif au complément
		String adjectifLieu = AdjectifsGenerator.getAnAdjectif();
		lieu.addModifier(adjectifLieu);

		String verb = StringUtils.isBlank(questionnaire.getVerb()) ? VerbGenerator.getAVerb() : questionnaire.getVerb();

		// PPPhraseSpec complementDuNomMatiere =
		// nlgFactory.createPrepositionPhrase("en", "pierre");
		// lieu.addModifier(complementDuNomMatiere);

		PPPhraseSpec dansLieux = nlgFactory.createPrepositionPhrase("dans", lieu);

		SPhraseSpec phrase = nlgFactory.createClause(sujet, verb, complement);
		phrase.setComplement(dansLieux);
		phrase.setFeature(Feature.TENSE, Tense.PAST);

		sentence.setSentence(realiser.realiseSentence(phrase));
		log.debug(sentence.getSentence());

		return sentence;
	}

}

package fr.fhacktory.nlg;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.fhacktory.model.Questionnaire;
import fr.fhacktory.model.Sentence;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.*;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.french.XMLLexicon;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Slf4j
public class PhraseGenerator {

	private NLGFactory nlgFactory;
	private Realiser realiser;
	private static final String template = "Hello, %s!";

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@PostMapping("/sentenceGenerator")
	@GetMapping("/sentenceGenerator")
	public Sentence generateSentence(@RequestBody Questionnaire questionnaire) {
		log.debug(questionnaire.toString());
		NPPhraseSpec sujet = nlgFactory.createNounPhrase(questionnaire.getSubject());
		NPPhraseSpec complement = nlgFactory.createNounPhrase("le", questionnaire.getComplement());
		NPPhraseSpec lieu = nlgFactory.createNounPhrase("le", questionnaire.getPlace());

		PPPhraseSpec complementDuNomCategorie = nlgFactory.createPrepositionPhrase("de", "campagne");
		lieu.addComplement(complementDuNomCategorie);
		PPPhraseSpec complementDuNomMatiere = nlgFactory.createPrepositionPhrase("en", "pierre");
		lieu.addModifier(complementDuNomMatiere);
		
		PPPhraseSpec dansLieux = nlgFactory.createPrepositionPhrase("dans", lieu);
		
		
//		
//		
//		
//		proposition = factory.createClause("elles", "aller");
//		PPPhraseSpec spAuParc = factory.createPrepositionPhrase("à", snLeParc);
//		proposition.setComplement(spAuParc);
//		outln(proposition);
//		
		
		

		SPhraseSpec phrase = nlgFactory.createClause(sujet, questionnaire.getVerb(), complement);
		phrase.setFeature(Feature.TENSE, Tense.PAST);
//		phrase.setFeature(Feature.PERFECT, true);
//		NPPhraseSpec snLeParc = factory.createNounPhrase("le", "parc");
		
		Sentence sentence = new Sentence();
		sentence.setSentence(this.realiser.realiseSentence(phrase));
		return sentence;
	}

	public PhraseGenerator() {
		super();
		Lexicon lexicon = new XMLLexicon();
		this.nlgFactory = new NLGFactory(lexicon);
		this.realiser = new Realiser();
	}

}

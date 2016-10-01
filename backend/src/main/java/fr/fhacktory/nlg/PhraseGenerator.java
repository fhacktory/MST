package fr.fhacktory.nlg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.fhacktory.model.Sentence;
import simplenlg.framework.*;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.french.XMLLexicon;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;

@RestController
public class PhraseGenerator {

	private NLGFactory nlgFactory;
	private Realiser realiser;
	private static final String template = "Hello, %s!";

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@RequestMapping("/sentenceGenerator")
	public Sentence generateSentence(@RequestParam(value = "subject", defaultValue = "Toto") String subject,
			@RequestParam(value = "verb", defaultValue = "Manger") String verb,
			@RequestParam(value = "complement", defaultValue = "pomme") String complement) {
		NPPhraseSpec theMan = nlgFactory.createNounPhrase(subject);
		NPPhraseSpec theCrowd = nlgFactory.createNounPhrase("le", complement);
		SPhraseSpec phrase = nlgFactory.createClause(theMan, verb, theCrowd);
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

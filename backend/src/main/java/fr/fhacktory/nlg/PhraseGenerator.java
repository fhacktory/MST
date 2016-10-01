package fr.fhacktory.nlg;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

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
	public String generateSentence(@RequestParam(value = "subject", defaultValue = "Toto") String subject,
			@RequestParam(value = "verb", defaultValue = "Manger") String verb,
			@RequestParam(value = "complement", defaultValue = "pomme") String complement) {
		SPhraseSpec p = nlgFactory.createClause();
		p.setSubject(subject);
		p.setVerb(verb);
		p.setObject(complement);
		return this.realiser.realiseSentence(p);
	}

	public PhraseGenerator() {
		super();
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		this.nlgFactory = new NLGFactory(lexicon);
		this.realiser = new Realiser(lexicon);
	}

}

package fr.fhacktory.nlg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.fhacktory.model.StepForm;
import fr.fhacktory.model.repository.SentenceRepository;
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
	
	@Autowired
	SentenceRepository sentenceRepository;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@PostMapping("/sentenceGenerator")
	@GetMapping("/sentenceGenerator")
	public List<Sentence> generateSentence(@RequestBody StepForm questionnaire) {
		log.debug(questionnaire.toString());
		List<Sentence> sentenceList = new ArrayList<>();
		try {
			NPPhraseSpec sujet = nlgFactory.createNounPhrase(questionnaire.getSubject());
			NPPhraseSpec complement = nlgFactory.createNounPhrase("le", questionnaire.getComplement());
			NPPhraseSpec lieu = nlgFactory.createNounPhrase("le", questionnaire.getPlace());

	
			// PPPhraseSpec complementDuNomMatiere =
			// nlgFactory.createPrepositionPhrase("en", "pierre");
			// lieu.addModifier(complementDuNomMatiere);

			PPPhraseSpec dansLieux = nlgFactory.createPrepositionPhrase("dans", lieu);

			SPhraseSpec phrase = nlgFactory.createClause(sujet, questionnaire.getVerb(), complement);
			phrase.setComplement(dansLieux);
			phrase.setFeature(Feature.TENSE, Tense.PAST);

			Sentence sentence = new Sentence();
			sentence.setSentence(this.realiser.realiseSentence(phrase));
			log.debug(sentence.getSentence());
			sentence = sentenceRepository.save(sentence);
			sentenceList.add(sentence);
			
			Sentence sentence2 = new Sentence();
			 PPPhraseSpec complementDuNomCategorie =
			 nlgFactory.createPrepositionPhrase("de", "campagne");
			 lieu.addComplement(complementDuNomCategorie);

			sentence2.setSentence(this.realiser.realiseSentence(phrase));
			log.debug(sentence2.getSentence());
			sentence2 = sentenceRepository.save(sentence2);
			sentenceList.add(sentence2);
			
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return sentenceList;
	}

	public PhraseGenerator() {
		super();
		Lexicon lexicon = new XMLLexicon();
		this.nlgFactory = new NLGFactory(lexicon);
		this.realiser = new Realiser();
	}

}

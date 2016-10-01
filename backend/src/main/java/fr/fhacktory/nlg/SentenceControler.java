package fr.fhacktory.nlg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.fhacktory.model.Sentence;
import fr.fhacktory.model.StepForm;
import fr.fhacktory.model.repository.SentenceRepository;
import fr.fhacktory.utils.SentenceGenerator;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }) //
@Slf4j
public class SentenceControler {

	private static final String template = "Hello, %s!";

	@Autowired
	SentenceRepository sentenceRepository;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@RequestMapping("/sentenceGenerator")
	public List<Sentence> generateSentence(@RequestBody StepForm questionnaire) {
		List<Sentence> sentenceList = SentenceGenerator.generateSentence(questionnaire);
		for (Sentence sentence : sentenceList) {
			sentenceRepository.save(sentence);
		}
		return sentenceList;
	}

}

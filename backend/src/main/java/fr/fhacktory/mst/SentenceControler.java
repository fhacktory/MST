package fr.fhacktory.mst;

import java.util.ArrayList;
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
import fr.fhacktory.model.Story;
import fr.fhacktory.model.repository.SentenceRepository;
import fr.fhacktory.model.repository.StoryRepository;
import fr.fhacktory.utils.SentenceGenerator;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }) //
@Slf4j
public class SentenceControler {

	private static final String template = "Hello, %s!";

	@Autowired
	SentenceRepository sentenceRepository;

	@Autowired
	StoryRepository storyRepository;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format(template, name);
	}

	@RequestMapping("/sentenceGenerator")
	public List<Sentence> generateSentence(@RequestBody StepForm questionnaire) {
		return handdleFormSubmit(questionnaire);
	}

	@RequestMapping("/fullStory")
	public List<Sentence> finishStory(@RequestBody StepForm questionnaire) {
		return handdleFormSubmit(questionnaire);
	}

	private List<Sentence> handdleFormSubmit(StepForm questionnaire) {
		// Récupération de l'histoire en cours
		Story currentStory = retrieveCurrentStory();

		// Ajout de la phrase choisie par l'utilisateur à l'histoire
		Sentence selectedSentence = sentenceRepository.findOne(questionnaire.getIdSentence());
		currentStory.getSentences().add(selectedSentence);

		List<Sentence> sentenceList;
		if (questionnaire.getActionType() == 3) {
			// Fin de l'histoire : on renvoie l'ensembles des phrases de
			// l'histoire
			sentenceList = currentStory.getSentences();
		} else {
			// Poursuite de l'histoire : on génère de nouvelles phrases que l'on
			// va renvoyer
			sentenceList = SentenceGenerator.generateSentence(questionnaire, currentStory);
			for (Sentence sentence : sentenceList) {
				sentenceRepository.save(sentence);
			}
		}

		return sentenceList;
	}

	private Story retrieveCurrentStory() {
		List<Story> stories = new ArrayList<>();
		storyRepository.findAll().forEach(stories::add);
		Story story;
		if (stories.isEmpty()) {
			story = new Story();
			storyRepository.save(story);
		} else {
			story = stories.get(0);
		}
		return story;
	}

}

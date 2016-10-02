package fr.fhacktory.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SentenceTest {

	@Test
	public void SentenceStepForm() throws Exception {
		StepForm stepForm = new StepForm();
		Sentence sentence = new Sentence(stepForm, new Story());
		log.warn(sentence.toString());
		assertThat(true);
	}

}

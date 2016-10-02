package fr.fhacktory.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.fhacktory.model.Sentence;
import fr.fhacktory.model.Story;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SentenceGeneratorTest {

	@Test
	public void sentenceToPhrase() throws Exception {
		Sentence sentence = new Sentence();
		sentence.setSubject("Toto");
		sentence.setVerb("manger");
		sentence.setComplement("pomme");
		sentence.setPlace("place");
		sentence.setAdjectivPlace("grand");
		sentence.setAdjectivComplement("rouge");
		String phrase = SentenceGenerator.sentenceToPhrase(sentence, new Story());
		log.warn(phrase);
		assertThat(phrase).isNotNull();
	}

}

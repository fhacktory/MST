package fr.fhacktory.nlg;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhraseGeneratorTest {

	    private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void greeting() throws Exception {
		 String body = this.restTemplate.getForObject("/greeting", String.class);
	        assertThat(body).isEqualTo("Hello World");
	}

}

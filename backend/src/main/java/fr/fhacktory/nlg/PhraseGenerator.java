package fr.fhacktory.nlg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseGenerator {

	 private static final String template = "Hello, %s!";

	    @RequestMapping("/greeting")
	    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return String.format(template, name);
	    }
	    
	    
	    @RequestMapping("/sentenceGenerator")
	    public String generateSentence(@RequestParam(value="subject", defaultValue="Toto") String subject, @RequestParam(value="verb", defaultValue="Manger") String verb, @RequestParam(value="complement", defaultValue="pomme") String complement) {
	        return String.format("%s %s %s", subject, verb, complement);
	    }

	    
}
	
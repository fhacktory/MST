package fr.fhacktory.nlg;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

/**
 * Created by aurelien.mino on 01/10/2016.
 */
public class NlgSimpleTest {

    private NLGFactory nlgFactory;
    private Realiser realiser;

    @Before
    public void setup() {
        Lexicon lexicon = Lexicon.getDefaultLexicon();
        this.nlgFactory = new NLGFactory(lexicon);
        this.realiser = new Realiser(lexicon);
    }

    @Test
    public void simpleEnSentence() {
        SPhraseSpec p = nlgFactory.createClause();
        p.setSubject("Mary");
        p.setVerb("chase");
        p.setObject("the monkey");

        Assertions.assertThat(this.realiser.realiseSentence(p)).isEqualTo("Mary chases the monkey.");
    }
}

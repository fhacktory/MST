package fr.fhacktory.nlg;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import simplenlg.framework.*;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.french.XMLLexicon;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;

/**
 * Created by aurelien.mino on 01/10/2016.
 */
public class NlgSimpleTest {

    private NLGFactory nlgFactory;
    private Realiser realiser;

    @Before
    public void setup() {
        Lexicon lexicon = new XMLLexicon();
        this.nlgFactory = new NLGFactory(lexicon);
        this.realiser = new Realiser();
    }

    @Test
    public void simpleFrenchSentence() {
        NPPhraseSpec theMan = nlgFactory.createNounPhrase("le", "homme");
        NPPhraseSpec theCrowd = nlgFactory.createNounPhrase("le", "foule");
        SPhraseSpec greeting = nlgFactory.createClause(theMan, "saluer", theCrowd);

        assertThat(this.realiser.realiseSentence(greeting)).isEqualTo("L'homme salue la foule.");
    }
}

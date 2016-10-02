package fr.fhacktory.utils;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VerbGeneratorTest {

    @Test
    public void testGetAVerb() throws Exception {
        assertThat(VerbGenerator.getAVerb()).isNotEmpty();
    }

}

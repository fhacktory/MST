package fr.fhacktory.utils;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdjectifsGeneratorTest {

    AdjectifsGenerator adjectifsGenerator = new AdjectifsGenerator();

    @Test
    public void testGetAnAdjectif() throws Exception {
	assertThat(adjectifsGenerator.getAnAdjectif()).isNotEmpty();
    }

}

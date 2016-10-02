package fr.fhacktory.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AdjectifsGeneratorTest {

	@Test
	public void testGetAnAdjectif() throws Exception {
		assertThat(AdjectifsGenerator.getAnAdjectif()).isNotEmpty();
	}

}

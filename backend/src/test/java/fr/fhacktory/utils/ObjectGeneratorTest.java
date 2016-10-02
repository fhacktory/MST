package fr.fhacktory.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ObjectGeneratorTest {

    @Test
    public void testGetPlace() throws Exception {
	assertThat(ObjectGenerator.getAnObject()).isNotEmpty();
    }
}

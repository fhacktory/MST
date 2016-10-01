package fr.fhacktory.model;

import lombok.Data;

@Data
public class Questionnaire {
	private String subject;
	private String verb;
	private String complement;
	private String place;
}

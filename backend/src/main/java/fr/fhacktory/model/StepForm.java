package fr.fhacktory.model;

import lombok.Data;

@Data
public class StepForm {
	private String subject;
	private String verb;
	private String complement;
	private String place;
	private int idSentence;
	private int actionType;
}

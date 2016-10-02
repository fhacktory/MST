package fr.fhacktory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import fr.fhacktory.utils.AdjectifsGenerator;
import fr.fhacktory.utils.PlaceGenerator;
import fr.fhacktory.utils.VerbGenerator;
import lombok.Data;

@Data
@Entity
public class Sentence implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	private String sentence;
	private String subject;
	private String verb;
	private String complement;
	private String place;
	private String adjectivComplement;
	private String adjectivPlace;

	/**
	 * @param questionnaire
	 * @return
	 */
	public Sentence(StepForm questionnaire) {
		super();

		if (StringUtils.isBlank(questionnaire.getSubject())) {
			setSubject("Cédric");
		} else {
			setSubject(questionnaire.getSubject());
		}
		if (StringUtils.isBlank(questionnaire.getComplement())) {
			setComplement("glace");
		} else {
			setComplement(questionnaire.getComplement());
		}
		// TODO : Aléatoire
		if (true) {
			setAdjectivComplement(AdjectifsGenerator.getAnAdjectif());
		}
		if (StringUtils.isBlank(questionnaire.getPlace())) {
			setPlace(PlaceGenerator.getPlace());
		} else {
			setPlace(questionnaire.getPlace());
		}
		// TODO : Aléatoire
		if (true) {
			setAdjectivPlace(AdjectifsGenerator.getAnAdjectif());
		}
		if (StringUtils.isBlank(questionnaire.getVerb())) {
			setVerb(VerbGenerator.getAVerb());
		} else {
			setVerb(questionnaire.getVerb());
		}
	}

}

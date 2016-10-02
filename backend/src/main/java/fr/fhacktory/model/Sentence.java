package fr.fhacktory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Sentence implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	private String sentence;
}

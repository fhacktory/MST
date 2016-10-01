package fr.fhacktory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Sentence implements Serializable {
	@Id
	private Integer id;
	private String sentence;
}

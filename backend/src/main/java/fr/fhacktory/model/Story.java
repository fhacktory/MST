package fr.fhacktory.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Story implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	private List<Sentence> sentences;
}

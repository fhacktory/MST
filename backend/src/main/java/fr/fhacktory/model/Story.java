package fr.fhacktory.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Story implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Sentence> sentences = new ArrayList<>();
}

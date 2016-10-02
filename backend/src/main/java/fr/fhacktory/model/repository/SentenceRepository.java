package fr.fhacktory.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.fhacktory.model.Sentence;

@Repository
public interface SentenceRepository extends CrudRepository<Sentence, Integer> {

}

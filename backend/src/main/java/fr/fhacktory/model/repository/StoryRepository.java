package fr.fhacktory.model.repository;

import fr.fhacktory.model.Sentence;
import fr.fhacktory.model.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<Story, Integer> {

}

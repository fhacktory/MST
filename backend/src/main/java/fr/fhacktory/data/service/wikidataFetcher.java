package fr.fhacktory.data.service;

import fr.fhacktory.model.Sentence;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.wikidata.wdtk.datamodel.helpers.Datamodel;
import org.wikidata.wdtk.datamodel.interfaces.EntityDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.datamodel.interfaces.Statement;
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;

import fr.fhacktory.model.Quote;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class WikidataFetcher {

	public String retrieveImageUrl(String word) {
		WikibaseDataFetcher wbdf = WikibaseDataFetcher.getWikidataDataFetcher();
		EntityDocument entity = wbdf.getEntityDocumentByTitle("frwiki", WordUtils.capitalizeFully(word));

		if(entity != null) {
			System.out.println(String.format("The Qid of %s is %s", word, entity.getEntityId().getId()));
		} else {
			System.out.println("No entity found...");
		}

		if (entity instanceof ItemDocument) {
			ItemDocument itemDoc = (ItemDocument) entity;
			Statement statement = itemDoc.findStatement(Datamodel.makeWikidataPropertyIdValue("P18"));
			if (statement != null && statement.getValue() != null) {
				String imageUrl = String.format("The image is http://commons.wikimedia.org/wiki/Special:FilePath/%s", statement.getValue().toString().replace("\"",""));
				System.out.println(String.format("The image is %s", imageUrl));
			}
		}
		return null;
	}

	public void retrieveImageForSentence(Sentence sentence) {
		String imageUrl = retrieveImageUrl(sentence.getSubject());
		if (imageUrl == null) {
			imageUrl = retrieveImageUrl(sentence.getPlace());
			if (imageUrl == null) {
				imageUrl = retrieveImageUrl(sentence.getComplement());
				if (imageUrl == null) {
					imageUrl = retrieveImageUrl(sentence.getVerb());
				}
			}
		}
		sentence.setImageUrl(imageUrl);

	}

}

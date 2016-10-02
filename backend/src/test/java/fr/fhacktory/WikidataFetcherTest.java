package fr.fhacktory;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.wikidata.wdtk.datamodel.helpers.Datamodel;
import org.wikidata.wdtk.datamodel.interfaces.EntityDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.datamodel.interfaces.Statement;
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;

/**
 * Created by aurelien.mino on 02/10/2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class WikidataFetcherTest {

    @Test
    public void testFetch() throws MediaWikiApiErrorException {
        String entityName = "Jardin";

        WikibaseDataFetcher wbdf = WikibaseDataFetcher.getWikidataDataFetcher();
        // wbdf.getFilter().setLanguageFilter(Collections.singleton("fr"));
        EntityDocument entity = wbdf.getEntityDocumentByTitle("frwiki", WordUtils.capitalizeFully(entityName));

        if(entity != null) {
            System.out.println(String.format("The Qid of %s is %s", entityName, entity.getEntityId().getId()));
        } else {
            System.err.println("No entity found...");
        }

        if (entity instanceof ItemDocument) {
            ItemDocument itemDoc = (ItemDocument) entity;
            Statement statement = itemDoc.findStatement(Datamodel.makeWikidataPropertyIdValue("P18"));
            System.out.println(String.format("The image is http://commons.wikimedia.org/wiki/Special:FilePath/%s", statement.getValue().toString().replace("\"","")));
        }
    }
}

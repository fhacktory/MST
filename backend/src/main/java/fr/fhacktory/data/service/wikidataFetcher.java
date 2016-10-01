package fr.fhacktory.data.service;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wikidata.wdtk.datamodel.interfaces.EntityDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;	
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;

@RestController
public class wikidataFetcher {

	public wikidataFetcher() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/callFetch")
	public String fetch(@RequestParam(value = "entityName", defaultValue = "Terry Pratchett") String entityName)
			throws MediaWikiApiErrorException {
		WikibaseDataFetcher wbdf = WikibaseDataFetcher.getWikidataDataFetcher();
//		wbdf.getFilter().setLanguageFilter(Collections.singleton("fr"));
		EntityDocument entity = wbdf.getEntityDocumentByTitle("frwiki", entityName);

		if (entity instanceof ItemDocument) {
			System.out.println(String.format("The Qid of %s is %s", entityName, entity.getEntityId().getId()));
			System.out.println(
					"The French label for entity Q8 is " + ((ItemDocument) entity).getLabels().get("fr").getText()
							+ "\nand its English Wikipedia page has the title "
							+ ((ItemDocument) entity).getSiteLinks().get("frwiki").getPageTitle() + ".");
		}
		return entity == null ? "No data found" : entity.getEntityId().getId();

		// System.out.println("*** Fetching data for one entity:");
		// EntityDocument q42 = wbdf.getEntityDocument("Q42");
		// System.out
		// .println("The current revision of the data for entity Q42 is "
		// + q42.getRevisionId());
		// if (q42 instanceof ItemDocument) {
		// System.out.println("The English name for entity Q42 is "
		// + ((ItemDocument) q42).getLabels().get("en").getText());
		// }
		//
		// System.out.println("*** Fetching data for several entities:");
		// Map<String, EntityDocument> results = wbdf.getEntityDocuments("Q80",
		// "P31");
		// // Keys of this map are Qids, but we only use the values here:
		// for (EntityDocument ed : results.values()) {
		// System.out.println("Successfully retrieved data for "
		// + ed.getEntityId().getId());
		// }
		//
		// System.out
		// .println("*** Fetching data using filters to reduce data volume:");
		// // Only site links from English Wikipedia:
		// wbdf.getFilter().setSiteLinkFilter(Collections.singleton("enwiki"));
		// // Only labels in French:
		// wbdf.getFilter().setLanguageFilter(Collections.singleton("fr"));
		// // No statements at all:
		// wbdf.getFilter().setPropertyFilter(
		// Collections.<PropertyIdValue> emptySet());
		// EntityDocument q8 = wbdf.getEntityDocument("Q8");
		// if (q8 instanceof ItemDocument) {
		// System.out.println("The French label for entity Q8 is "
		// + ((ItemDocument) q8).getLabels().get("fr").getText()
		// + "\nand its English Wikipedia page has the title "
		// + ((ItemDocument) q8).getSiteLinks().get("enwiki")
		// .getPageTitle() + ".");
		// }
		//
		// System.out.println("*** Fetching data based on page title:");
		// EntityDocument edPratchett = wbdf.getEntityDocumentByTitle("enwiki",
		// "Terry Pratchett");
		// System.out.println("The Qid of Terry Pratchett is "
		// + edPratchett.getEntityId().getId());
		//
		// System.out.println("*** Fetching data based on several page
		// titles:");
		// results = wbdf.getEntityDocumentsByTitle("enwiki", "Wikidata",
		// "Wikipedia");
		// // In this case, keys are titles rather than Qids
		// for (Entry<String, EntityDocument> entry : results.entrySet()) {
		// System.out
		// .println("Successfully retrieved data for page entitled \""
		// + entry.getKey() + "\": "
		// + entry.getValue().getEntityId().getId());
		// }
		//
		// System.out.println("*** Done.");
	}
}

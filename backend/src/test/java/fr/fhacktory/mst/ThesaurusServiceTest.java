package fr.fhacktory.mst;

import fr.fhacktory.data.service.ThesaurusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aurelien.mino on 01/10/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThesaurusServiceTest {

    @Autowired
    private ThesaurusService thesaurusService;

    @Test
    public void anniversaireIsSynonymOfFete() {
        assertThat(thesaurusService.findSynonym("anniversaire")).contains("fête");
    }
}

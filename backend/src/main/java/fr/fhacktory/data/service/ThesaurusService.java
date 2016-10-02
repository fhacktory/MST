package fr.fhacktory.data.service;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

/**
 * Created by aurelien.mino on 01/10/2016.
 */
@Service
@Log
public class ThesaurusService {

    @Value(value = "${thesaurus.webservice.endpoint}")
    private String webserviceEndpoint;

    @Value(value = "${thesaurus.webservice.key}")
    private String webserviceKey;

    private String webserviceLanguage = "fr_FR";

    public List<String> findSynonym(String word) {

        List<String> synonyms = new ArrayList<>();

        try {
            URL serverAddress = new URL(webserviceEndpoint + "?word=" + URLEncoder.encode(word, "UTF-8") + "&language=" + webserviceLanguage + "&key=" + webserviceKey + "&output=json");
            HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection();
            connection.connect();
            int rc = connection.getResponseCode();
            if (rc == 200) {
                String line = null;
                BufferedReader br = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line + '\n');
                }
                JSONObject obj = (JSONObject) JSONValue.parse(sb.toString());
                JSONArray array = (JSONArray) obj.get("response");
                for (int i = 0; i < array.size(); i++) {
                    JSONObject list = (JSONObject) ((JSONObject) array.get(i)).get("list");
                    System.out.println(list.get("category")+":"+list.get("synonyms"));
                    String synonymsString = (String) list.get("synonyms");
                    synonyms.addAll(Arrays.asList(synonymsString.split("\\|")));
                }
            } else {
                System.out.println("HTTP error:" + rc);
            }
            connection.disconnect();
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (java.net.ProtocolException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return synonyms;
    }

}

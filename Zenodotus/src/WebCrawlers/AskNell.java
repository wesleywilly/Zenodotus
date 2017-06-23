/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebCrawlers;

import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author WesleyW
 */
public class AskNell {

    private static final String URL = "http://rtw.ml.cmu.edu/rtw/api/json0?";
    private static final String ENT1 = "ent1=";
    private static final String ENT2 = "&ent2=";
    private static final String LIT1 = "&lit1=";
    private static final String PREDICATE = "&predicate=";
    private static final String LIT2 = "&lit2=";
    private static final String AGENT = "&agent=";
    private static final String FORMAT = "&format=raw";

    //private static final String KI = "KI";
    private static final String KB = "KB";
    //private static final String CKB = "CKB";
    //private static final String OCMC = "OCMC";
    //private static final String OPRA = "OPRA";
    //private static final String ORWR = "ORWR";
    //private static final String UNMAP = "UNMAP";
    //private static final String CMAP = "CMAP";

    public static JSONObject getMLCategories(String lit1, String predicate) {
        //Removing spaces
        lit1 = lit1.replaceAll(" ", "+");
        predicate = predicate.replaceAll(" ", "+");

        //Generating the query
        String query = URL + LIT1 + lit1 + PREDICATE + predicate + AGENT + KB + FORMAT;

        //Connecting
        JSONObject result = new JSONObject();
        Document doc = null;

        boolean connected = false;

        while (!connected) {
            try {
                //Reading page
                doc = Jsoup.connect(query).get();
                
                //doc = Jsoup.parse(new URL(query),30000);
                connected = true;

            } catch (Exception e) {
                System.out.println("[ASKNELL] Connection Error!");
                e.printStackTrace();
                try {
                    Thread.sleep(3000);
                } catch (Exception te) {
                    System.out.println("[ASKNELL] Thread Error!");
                    //te.printStackTrace();
                }

            }
            
            //Getting informations
            Elements bodies = doc.getElementsByTag("body");
            
            JSONParser parser = new JSONParser();
            try{
                result = (JSONObject) parser.parse(bodies.first().text());
                
            }catch(Exception e){
                System.out.println("[ASKNELL] Parser Error!");
                e.printStackTrace();
            }
            
        }

        return result;
    }

}

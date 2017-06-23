
import Utilities.FileUtilities;
import WebCrawlers.Zenodotus;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wesley
 */
public class GetCategoryInstance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONObject actor = Zenodotus.getCategoryInstance("actor","al_pacino");
        FileUtilities.save(actor, "alpacino.json");
    }
    
}

import Utilities.FileUtilities;
import WebCrawlers.Zenodotus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author wesley
 */
public class SearchCategoryInstance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JSONArray instances = Zenodotus.searchCategoryInstance("matrix");
        System.out.println(instances);
        
        /*
            Saving resulsts in a file.
        */
        JSONObject result = new JSONObject();
        result.put("instances_founded", instances);
        
        FileUtilities.save(result, "result.json");
        
    }
    
}

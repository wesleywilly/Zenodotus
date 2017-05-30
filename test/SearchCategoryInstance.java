import WebCrawlers.Zenodotus;
import org.json.simple.JSONArray;

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
    }
    
}

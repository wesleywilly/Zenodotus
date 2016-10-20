/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASKNELLModel;

import Utilities.JSONUtillities;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class Item {
    private static final String ENT1  = "ent1";
    private static final String PREDICATE  = "predicate";
    private static final String JUSTIFICATIONS  = "justifications";
    
    private String ent1;
    private String predicate;
    private List<Justification> justifications;

    public Item(JSONObject jItem){
        ent1 = (String) jItem.get(ENT1);
        predicate = (String) jItem.get(PREDICATE);
        justifications = JSONArrayToJustificationList((JSONArray)jItem.get(JUSTIFICATIONS));
    }
    
    public JSONObject toJSON(){
        JSONObject jItem = new JSONObject();
        jItem.put(ENT1, ent1);
        jItem.put(PREDICATE, predicate);
        jItem.put(JUSTIFICATIONS, JustificationListToJSONArray(justifications));
        
        return jItem;
    }
    
    private static List<Justification> JSONArrayToJustificationList(JSONArray jArray){
        List<Justification> sArray = new ArrayList<Justification>();
        
        for (Object object : jArray) {
            Justification justification = new Justification((JSONObject)object);
            sArray.add(justification);
        }
        
        return sArray;
    }
    
    private static JSONArray JustificationListToJSONArray(List<Justification> sArray){
        JSONArray jArray = new JSONArray();
        
        for (Justification justification : sArray) {
            jArray.add(justification.toJSON());
        }
        
        return jArray;
    }
    
    public String getEnt1() {
        return ent1;
    }

    public void setEnt1(String ent1) {
        this.ent1 = ent1;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public List<Justification> getJustifications() {
        return justifications;
    }

    public void setJustifications(List<Justification> justifications) {
        this.justifications = justifications;
    }
    
    
    
}

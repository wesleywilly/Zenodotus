/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASKNELLModel;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class Result {
    private static final String KIND = "kind";
    private static final String ITEMS = "items";
    private static final String ENT_MAP = "entMap";
    
    private static final String ERROR = "error";
    
    private String kind;
    private List<Item> items;
    private List<EntMap> entMap;

    public Result(JSONObject jResult){
        kind = (String) jResult.get(KIND);
        if(!kind.equals(ERROR)){
        items = JSONArrayToItemList((JSONArray) jResult.get(ITEMS));
        entMap = JSONArrayToEntMapList((JSONArray) jResult.get(ENT_MAP));
        }else{
            items = new ArrayList<Item>();
            entMap = new ArrayList<EntMap>();
        }
    }
    
    private static List<Item> JSONArrayToItemList(JSONArray jArray){
        List<Item> oArray = new ArrayList<Item>();
        
        for (Object object : jArray) {
            Item item = new Item((JSONObject)object);
            oArray.add(item);
        }
        
        return oArray;
    }
    
    private static JSONArray ItemListToJSONArray(List<Item> sArray){
        JSONArray jArray = new JSONArray();
        
        for (Item item : sArray) {
            jArray.add(item.toJSON());
        }
        
        return jArray;
    }
    
        private static List<EntMap> JSONArrayToEntMapList(JSONArray jArray){
        List<EntMap> oArray = new ArrayList<EntMap>();
        
        for (Object object : jArray) {
            EntMap entMap = new EntMap((JSONObject)object);
            oArray.add(entMap);
        }
        
        return oArray;
    }
    
    private static JSONArray EntMapListToJSONArray(List<EntMap> oArray){
        JSONArray jArray = new JSONArray();
        
        for (EntMap entMap : oArray) {
            jArray.add(entMap.toJSON());
        }
        
        return jArray;
    }
    
    
    
    
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<EntMap> getEntMap() {
        return entMap;
    }

    public void setEntMap(List<EntMap> entMap) {
        this.entMap = entMap;
    }
    
    
    
}

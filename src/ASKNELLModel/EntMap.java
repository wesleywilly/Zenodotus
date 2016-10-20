/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASKNELLModel;

import Utilities.JSONUtillities;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class EntMap {
    private static final String ENTITY = "entity";
    private static final String REFERRED_TO_BY_TOKEN = "referredToByToken";
    private static final String LITERAL_STRING = "literalString";
    
    private String entity;
    private List<String> referredToByToken;
    private List<String> literalString;

    public EntMap(JSONObject jEntMap){
        entity = (String) jEntMap.get(ENTITY);
        referredToByToken = JSONUtillities.JSONArrayToStringList((JSONArray)jEntMap.get(REFERRED_TO_BY_TOKEN));
        literalString = JSONUtillities.JSONArrayToStringList((JSONArray) jEntMap.get(LITERAL_STRING));
    }
    
    public JSONObject toJSON(){
        JSONObject jEntMap = new JSONObject();
        jEntMap.put(ENTITY, entity);
        jEntMap.put(REFERRED_TO_BY_TOKEN,JSONUtillities.StringListToJSONArray(referredToByToken));
        jEntMap.put(LITERAL_STRING,JSONUtillities.StringListToJSONArray(literalString));
        
        return jEntMap;
    }
    
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<String> getReferredToByToken() {
        return referredToByToken;
    }

    public void setReferredToByToken(List<String> referredToByToken) {
        this.referredToByToken = referredToByToken;
    }

    public List<String> getLiteralString() {
        return literalString;
    }

    public void setLiteralString(List<String> literalString) {
        this.literalString = literalString;
    }
   
    
    
}

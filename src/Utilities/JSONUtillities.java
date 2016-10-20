/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class JSONUtillities {
    public static List<String> JSONArrayToStringList(JSONArray jArray){
        List<String> sArray = new ArrayList<String>();
        
        for (Object object : jArray) {
            sArray.add((String) object);
        }
        
        return sArray;
    }
    
    public static JSONArray StringListToJSONArray(List<String> sArray){
        JSONArray jArray = new JSONArray();
        
        for (String string : sArray) {
            jArray.add(string);
        }
        
        return jArray;
    }

    
}

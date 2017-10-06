/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Lukas
 */
public class Jsondecodingsingle {
    
    public static JSONObject write(String anweisung, String data)
    {
        JSONObject obj = new JSONObject();
        obj.put("anweisung", anweisung);

        JSONArray list = new JSONArray();
            list.add(data);
  
        
        obj.put("messages", list);
        
        System.out.print(obj);
        return obj;
    }
    
    
}

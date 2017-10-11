package server.json;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Jsondecoding {
    
        
    public static JSONObject write(String anweisung, String[] data)
    {
        JSONObject obj = new JSONObject();
        obj.put("anweisung", anweisung);

        JSONArray list = new JSONArray();
        for(int i = 1; i<data.length ; i++)
        {
            System.out.println(data.length);
            list.add(data[i]);
        }
        
        obj.put("messages", list);
        
        System.out.println(obj);
        return obj;
    }
    
}

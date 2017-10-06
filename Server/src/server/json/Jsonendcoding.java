/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.json;

import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Lukas
 */
public class Jsonendcoding {
    
   public static String[] decoiding(Object obj)
   {
       String[] str = new String[10];
       int i = 1;
       JSONParser parser = new JSONParser();
       JSONObject jsonObject = (JSONObject) obj;
       
       
       System.out.println(jsonObject);
       
       
       str[0] = (String) jsonObject.get("anweisung");
       System.out.println(str[1]);
       //loop array
       JSONArray msg = (JSONArray) jsonObject.get("messages");
       Iterator<String> iterator = msg.iterator();
       while (iterator.hasNext()) {
           String name = null;
           name = iterator.next();
           str[i] = name;
           i++;
       }      
       return str;
   }
}

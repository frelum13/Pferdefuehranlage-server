/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.protocol;

import org.json.simple.JSONObject;
import server.datenbank.Datenbanklesen;
import server.datenbank.Datenbankloeschen;

import server.datenbank.Loginueberpruefen;
import server.datenbank.Datenbankschreiben;
import server.datenbank.Datenbankupdate;
import server.json.Jsondecoding;
import server.json.Jsondecodingsingle;



/**
 *
 * @author Lukas
 */
public class Protocol {
        //String arrays
        private final String[] str;
        private String[] get;  
        private String[] registrate;
        private String[] login = new String[100];
        //Strings
        private String singleget = null;     
        //Datenbank
        private Datenbanklesen lesen = null;
        private Datenbankschreiben schreiben = null;
        private Datenbankupdate update = null;
        private Datenbankloeschen loeschen= null;
        
        private Loginueberpruefen ueberpfruefen = null;
        //Json
        private JSONObject antwort;

    public Protocol(String[] str) {
        this.str = str;
        
        input();
    }

    public JSONObject getAntwort() {
        return antwort;
    }
         
    private void input()
    {
        
        System.out.println("In Input verarbeiten");
        
            switch(str[0])
            {
                case "get":
                    
                break;
                case "status":
                    antwort = Jsondecodingsingle.write("status", "hier");
                break;
                case "start":
                    antwort = Jsondecodingsingle.write("start", "true");
                 break;  
                case "water":
                    
                    System.out.format("%s\n",str[1]);
                    
                   
                    antwort = Jsondecodingsingle.write("water", str[1]);
                    break;
                case "stop":
                    System.out.format("%s\n",str[1]);
                    antwort = Jsondecodingsingle.write("stop", str[1]);
                break;
                case "new":
                    String[] inserthorse = new String[str.length-1];
                    for(int j = 1; j < str.length; j++)
                        inserthorse[j-1] = str[j]; 
                    
                    schreiben = new Datenbankschreiben("horses", inserthorse);
                    singleget = schreiben.getAbfrage();
                                   
                    antwort = Jsondecodingsingle.write("new", singleget);
                 break;   
                case "updatehorse":
                {
                    update = new Datenbankupdate("horses", str);
                    singleget = update.getAbfrage();
                    
                    antwort = Jsondecodingsingle.write("updatehorse", singleget);
                    
                }
                break;
                case "updatelogin":
                {
                    update = new Datenbankupdate("login", str);
                    singleget = update.getAbfrage();
                    
                    antwort = Jsondecodingsingle.write("updateuser", singleget);
                } 
                break;
                case "deletehorse":
                    
                    loeschen = new Datenbankloeschen("login", str[1]);
                    singleget = loeschen.getCheck();
                    
                    antwort = Jsondecodingsingle.write("deletehorse", singleget);
                    break;
                case "deleteuser":
                    
                    
                   loeschen = new Datenbankloeschen("horses", str[1]);
                   singleget = loeschen.getCheck();
                    
                    antwort = Jsondecodingsingle.write("deleteusr", singleget);
                    break;
                case "infohorse":
                    
                    lesen = new Datenbanklesen("Infohorse", str[1]);
                    get = lesen.getListe();
                    
                   antwort = Jsondecoding.write("infohorse", get);
                   break;
                    
                case "infouser":
                    
                    lesen = new Datenbanklesen("Infouser", str[1]);
                    get = lesen.getListe();
                                        
                    antwort = Jsondecoding.write("infouser", get);
                    break;
                case "registrate":
                    
                    for(int z = 1; z < str.length; z++)
                     registrate[z-1] = str[z];
                    
                    schreiben = new Datenbankschreiben("login", registrate);
                    singleget = schreiben.getAbfrage();
                    
                    antwort = Jsondecodingsingle.write("registrate", singleget);
                    break;
                case "login":
                      
                      for(int i=1 ; i < str.length ; i++)
                        login[i-1] = str[i]; 
                       
                      ueberpfruefen = new Loginueberpruefen(login[0], "login");
                      singleget = ueberpfruefen.getCheck();
                      
                      
                      if("true".equals(singleget))
                      {
                          lesen = new Datenbanklesen("Password", login[1]);
                          get = lesen.getListe();
                                                    
                          System.out.println("get: " + get[0]);
                          System.out.println("login: " + login[1]);
                          boolean what = login[1].equals(get[0]);
                          if(what == true)
                          {
                              antwort = Jsondecodingsingle.write("login", "true");
                          }
                          else
                          {
                              antwort = Jsondecodingsingle.write("login", "Falsches Passwort");
                          }
                          
                      }
                      else
                      {
                          antwort = Jsondecodingsingle.write("login", "false1");
                      }
                      break;
                default:
                    System.out.println("Falsche Anweisung");
                    antwort = Jsondecodingsingle.write("default", "err03");
                
            }
    }
    
    
}

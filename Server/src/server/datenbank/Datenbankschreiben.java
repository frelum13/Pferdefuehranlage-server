/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lukas
 */
public class Datenbankschreiben {
    
    private final String table;
    private final String[] inhalt;
    private String abfrage;

    public Datenbankschreiben(String table, String[] inhalt) {
        this.table = table;
        this.inhalt = inhalt;
        
        schreiben();
    }  
    
    Connect connect = new Connect("horse");
    
    private void schreiben()
    {   
        
        try {
            
                String sql;
            
                
                Connection myCon = connect.getConn();
            
                System.out.println("Mit Datenbank verbunden");
                Statement myStmt = myCon.createStatement();
                if(table == "login")
                {
                    sql ="insert into "+ table + 
                            "(firstname,secondname,username,password)"+ 
                            "values ('" + inhalt[0] + "','" + inhalt[1] + "','" + inhalt[2] + "','" + inhalt[3] + "')";
                }
                else
                {
                    sql ="insert into "+ table + "(id,name,time,richtungsaenderungen)"+ "values ('5','" + inhalt[0] + "','" + inhalt[1] + "','" + inhalt[2] + "')";
                }
                myStmt.executeUpdate(sql);
                           
        } catch (SQLException | NullPointerException e) 
        {
            abfrage = connect.getError();
        }
        
        abfrage =  "true";
    }

    public String getAbfrage() {
        return abfrage;
    }
    
}

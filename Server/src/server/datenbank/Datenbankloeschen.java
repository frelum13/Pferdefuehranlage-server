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
public class Datenbankloeschen {
    
    private final String table;
    private final String name;
    
    private String check;

    public Datenbankloeschen(String table, String name) {
        this.table = table;
        this.name = name;
        
        loeschen();
    }
   
    
    
    private void loeschen()
    {   
        Connect connect = new Connect("horse");
        
        try {
            
                String sql;
           
                Connection myCon = connect.getConn();
            
                System.out.println("Mit Datenbank verbunden");
                Statement myStmt = myCon.createStatement();
                if(table == "login")
                {
                    sql ="DELETE FROM login WHERE username = '" + name + "'";
                    
                }
                else
                {
                    sql = "DELETE FROM horses WHERE name = '" + name + "'";
                    
                }
                myStmt.executeUpdate(sql);
                check = "true";
                           
        } catch (SQLException | NullPointerException e) {
            
            check = connect.getError();
        }
    }

    public String getCheck() {
        return check;
    }
        
}

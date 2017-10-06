/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lukas
 */
public class Datenbankupdate {
    
    private final String table;
    private final String[] inhalt;
    private String abfrage;

    public Datenbankupdate(String table, String[] inhalt) {
        this.table = table;
        this.inhalt = inhalt;
        
        update();
    }  
    
    Connect connect = new Connect("horse");
    
    private void update()
    {   
        
        try {
            
                String sql;
            
                
                Connection myCon = connect.getConn();
            
                System.out.println("Mit Datenbank verbunden");
                PreparedStatement myStmt = null;
                if(table == "login")
                {
                    myStmt = (PreparedStatement) myCon.prepareStatement("update login set firstname ='" + inhalt[2] + "', secondname ='"+ inhalt[3] +"', password ='"+ inhalt[4] + "' where username='" + inhalt[1] +"'" );
                }
                else
                {
                    myStmt = (PreparedStatement) myCon.prepareStatement("update horses set richtungsaenderungen ='" + inhalt[3] + "', time ='" + inhalt[2] + "' where name='" + inhalt[1] +"'" );
                }
                myStmt.executeUpdate();
                abfrage =  "true";
                           
        } 
        catch (NullPointerException e) 
        {
            abfrage = connect.getError();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            abfrage = "problem";
        }
        
    }

    public String getAbfrage() {
        return abfrage;
    }
    
}

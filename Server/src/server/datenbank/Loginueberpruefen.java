/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Lukas
 */
public class Loginueberpruefen {
    
    private final String name;
    private final String tabelle;
    
    private String check;
    
    Connect connect = new Connect("horse");
    
    public Loginueberpruefen(String name, String tabelle) {
        this.name = name;
        this.tabelle = tabelle;
        
        ueberpruefen();
    }
    
    private void ueberpruefen() 
    {
        
        try
        {
            String sql;
            boolean abfrage = false;
            
            System.out.println("Loginüberpruefen: vor dem connecten");

            Connection conn = connect.getConn();

                       
            System.out.println("Loginüberpruefen: Mit Datenbank verbunden");
            Statement st = conn.createStatement();
            System.out.println("Statment");
            
            if(tabelle == "login")
                sql = ("SELECT * FROM login WHERE username = " + "'" + name + "'");         
            else
                sql = ("SELECT * FROM horse WHERE name = " + "'" + name + "'");
            ResultSet myRs = st.executeQuery(sql);
            
            abfrage = myRs.next();
            
            check = String.valueOf(abfrage);
            
        } catch (SQLException | NullPointerException e)
        {
            check = connect.getError();
            System.out.println(connect.getError());
        }
    }

    public String getCheck() {
        return check;
    }
}

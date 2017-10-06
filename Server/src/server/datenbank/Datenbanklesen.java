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
 * @author marinaspari
 */
public class Datenbanklesen
{
    private final String read;
    private final String name;
    private String[] liste;
    Connect connect = new Connect("horse");
    

    public Datenbanklesen(String read, String name) {
        this.read = read;
        this.name = name;
        
        lesen();
    }

    public String[] getListe() {
        return liste;
    }
  
    private void lesen()
    {
        try
        {
            int i;
            String sql;
            ResultSet myRs;
            
            Connection conn = connect.getConn();
            
            Statement st = conn.createStatement();
            
            switch(read)
            {
                case "Password":
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                    myRs = st.executeQuery(sql);
                    while (myRs.next())
                    {
                        System.out.println("Password: " + myRs.getString(5));
                        liste[1] =  myRs.getString(5);                                 
                    }
                    System.out.println("nope");
                break;
                case "Infouser":
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                    System.out.println(sql);
                    myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                        for(i=1; i<=5; i++)
                             liste[i-1]=myRs.getString(i);
                    }
                case "Infohorse":
                    sql =  "SELECT * FROM horses WHERE name = '" + name + "'";
                    myRs = st.executeQuery(sql);
                    while (myRs.next()) {
                        for(i=1; i<=3; i++)
                             liste[i-1]=myRs.getString(i);
                    }
                break;
                default: 
                {
                    liste[0] = "Error";   
                }
            }               
        }
        catch(SQLException | NullPointerException e)
        {
            liste[0]= connect.getError();
        }
    }
}
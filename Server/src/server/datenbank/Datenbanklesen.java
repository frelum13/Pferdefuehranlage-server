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
    
    private final Connect connect = new Connect("horse");
    private final Connection conn = connect.getConn();
    
    
    
    private String sql;
    private ResultSet myRs;

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
            Statement st = conn.createStatement();
            
            
            switch(read)
            {
                case "Password":
                    liste = new String[5];
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
<<<<<<< HEAD
                    
                    myRs = st.executeQuery(sql);
                    liste[0] = myRs.getString(5);
                    
=======
                   
                    myRs = st.executeQuery(sql);
                    
                    System.out.println(myRs.next());
                    while (myRs.next()) 
                    {
                        liste = new String[5];
                        for(i=1; i<=liste.length; i++)
                            liste[i-1] = myRs.getString(i);

                    }
>>>>>>> 9af28b9b1ba29f63fc9e52cd45e665da1f670477
                break;
                case "Infouser":
                    liste = new String[5];
                    sql =  "SELECT * FROM login WHERE username = '" + name + "'";
                   
                    myRs = st.executeQuery(sql);
<<<<<<< HEAD
                    
                    while (myRs.next()) {
                        
=======
                    while (myRs.next()) 
                    {
                        liste = new String[5];
>>>>>>> 9af28b9b1ba29f63fc9e52cd45e665da1f670477
                        for(i=1; i<=liste.length; i++)
                            liste[i-1] = myRs.getString(i);

                    }
                break;
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
        catch(SQLException e)
        {
            liste[0]= connect.getError();
        }
        catch(NullPointerException e)
        {
             liste[0] = "NullPointEX";
        }
    }
}
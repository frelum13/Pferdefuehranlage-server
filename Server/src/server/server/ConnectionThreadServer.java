package server.server;

import server.protocol.Protocol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.json.Jsonendcoding;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConnectionThreadServer implements Runnable
{
    private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());
    
    private final Socket socket;

    public ConnectionThreadServer(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run()
    {
    
        try{
           
            // Variablen Deklaration
            String[] str;
            JSONObject antwort = null;
            JSONObject obj = null;
            String stringantwort = null;
            JSONParser parser = new JSONParser();
            
            log.info("In Connection Thread");
            
            final BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
            final BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
                     
            try {
                 // Empfangen 
                obj = (JSONObject) parser.parse(r.readLine());
            } catch (ParseException ex) {
                w.write("err02");
                w.flush();
            }

            
            log.log(Level.INFO, "ConnectionThread:{0}Empfangenes Telegramm", obj);
            str = Jsonendcoding.decoiding(obj);
            log.info("ConnectionThread: Start des Protokolls");
            
            // Aufruf Protokoll
            Protocol protocol = new Protocol(str);
            antwort = protocol.getAntwort();
                       
            // Umwandeln von Antwort in String
            stringantwort = antwort.toJSONString();
            
            //senden
            w.write(stringantwort);
            w.flush();
        }
        catch (IOException ex) {
            Logger.getLogger(ConnectionThreadServer.class.getName()).log(Level.SEVERE, "IOException", ex);
        }         
        finally
        {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionThreadServer.class.getName()).log(Level.SEVERE, "Socket close IOException", ex);
            }
        }
        
        

    }
    
}

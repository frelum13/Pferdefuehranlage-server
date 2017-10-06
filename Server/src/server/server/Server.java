
package server.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
  private final int port;
  
  private final static Logger log = Logger.getLogger(ConnectionThreadServer.class.getName());

  public Server (int port)
  {
    this.port = port;
  }
    
public void start() throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(port);
    
    log.info("Server: Server gestarted");
    
    // accept blockiert Programmablauf bis ein Client
    // eine Verbindung herstellt (SYN, SYN+ACK, ACK)
    while (true)
    {
      Socket socket = serverSocket.accept();
      socket.setSoTimeout(100);      
      log.log(Level.INFO, "Server: Verbindung hergestellt: {0}", socket);
      // System.out.println("Verbindung hergstellt: " + socket);
      new Thread(new server.server.ConnectionThreadServer(socket)).start();
    }
    
//            serverSocket.close();
//            System.out.println("socket closed");
  }

  public static void main (String[] args) throws IOException
  {
    new Server(1111).start();
  }
  
}

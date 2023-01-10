package chatting;
import java.net.*;

public class Server {
  public static void main(String[] args) {
    Socket socket = null;
    User user = new User();
    ServerSocket server_socket = null;
    
    int count = 0;
    Thread thread[] = new Thread[10];
    
    try{
      server_socket = new ServerSocket(4444);
      
      while(true) {
        socket = server_socket.accept();
        
        thread[count] = new Thread(new Receiver(user,socket));
        thread[count].start();
        count++;
      }
    }catch(Exception e) {
    }
  }
}

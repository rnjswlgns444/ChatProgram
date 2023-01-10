package chatting;
import java.io.DataInputstream
import java.net.Socket;

public class Receiver implements Runnable {
  Socket socket;
  DataInputStream in;
  String name;
  User user = new User();
  
  public Receiver(User user, Socket socket) throws Exception {
    this.user = user;
    this.socket = socket;
    in = new DataInputStream(socket.getInputStream());
    this.name  in.readUTF();
    user.AddClient(name, socket);
  }
  
  public void run() {
    try {
      while(true) {
        String msg = in.readUTF();
        user.sendMsg(msg,name);
      }
    }catch(Exception e) {
      user.RemoveClient(this.name);
    }
  }
}

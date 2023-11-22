package base;
import java.net.InetAddress;


public class ConnectionGenius {

  InetAddress ipa;
  
  public ConnectionGenius(InetAddress ipa) {
    this.ipa = ipa;
  }

  public void fireUpGame() {
  System.out.println("FireUpGame function invoked!");
  }

}
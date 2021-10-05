package network;

import java.io.IOException;

public class ChatMain {
	public static void main(String[] args) {
		try {
			Server server = new Server(5555);
			
			server.runServer();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

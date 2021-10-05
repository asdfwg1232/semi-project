package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver extends Thread {
	private Socket socket;
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			while(true) {
				//서버로 부터 온 메세지를
				//콘솔에 출력하는 기능
				System.out.println(br.readLine());
			}
			
		}catch (IOException e) {
			System.out.println("감독님과 연결을 종료합니다.");
		}
	}

}


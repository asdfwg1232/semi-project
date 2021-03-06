package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread {
	private Socket socket;
	
	public ClientSender(Socket socket) {
		this.socket = socket;
		
	}
	public void run() {
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
			Scanner scan = new Scanner(System.in);
			System.out.println("보낼 메세지를 입력해주세요");
			
			while(true) {
				String msg = scan.nextLine();
				if(msg.equals("Q")) {
					System.out.println("종료합니다.");
					break;
				}
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

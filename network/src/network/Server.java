package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	
	private ServerSocket serverSocket;
	private List<Server.User> userList;
	

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		userList = new ArrayList<Server.User>();
	}
	

	public void runServer() throws IOException {
		while(true) {
			System.out.println("접속중...");
			Socket socket = serverSocket.accept();
			System.out.println("접속 : "+socket.getInetAddress()+"-"+socket.getPort());
			
			User user = new User(socket);
			
			userList.add(user);
			
			user.start();
		}
	}
	
	//접속자에 대한 정보를 저장하는 클래스
	class User extends Thread{
		private String name;
		private Socket socket;
		private BufferedWriter bw;
		
		public User(Socket socket) throws IOException {
			this.socket = socket;
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}
		@Override
		public void run() {
			BufferedReader br = null;
			try {
				System.out.println("--- 서버 스레드 실행 ---");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				bw.write("선수 이름을 입력해주세요. \n");
				bw.flush();
				
				this.name = br.readLine();
				for(User user : userList) {
					if(this != user) {
						user.bw.write(name+"님이 접속하였습니다.");
						user.bw.newLine();
						user.bw.flush();
					}
				}
				
				String msg = null;
				while(true) {
					msg = br.readLine();
					if(msg == null) {
						throw new Exception();
					}
					for(User user : userList) {
						if(this != user) {
							user.bw.write("["+name+"] : "+msg);
							user.bw.newLine();
							user.bw.flush();
						}
					}
				}
			}catch(Exception e) {
				userList.remove(this);
				try {
					for(User user : userList) {
						user.bw.write(name+"님이 방을 나갔습니다.");
						user.bw.newLine();
						user.bw.flush();
					}
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
			
	}
	
		
	
	
	

}




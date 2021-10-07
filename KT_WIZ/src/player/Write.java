package Player

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Testmi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PlayerDao dao = PlayerDaoImpl.getInstance();
		Batterplayer bp = new Batterplayer();
		
		String filepath = "c:\\test\\";
		String filename = "test.txt";
		
		int years = 2021;
		try {
			List<Batterplayer> playerList = dao.PlayerYears_batterFindAll(years);
			for(Batterplayer player : playerList) {
				System.out.println(player);
			}
			dao.writePlayerFile(filepath, filename, playerList);
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

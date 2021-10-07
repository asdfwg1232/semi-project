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
			dao.writeBatterplayerFile(filepath, filename, playerList);
			
			
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

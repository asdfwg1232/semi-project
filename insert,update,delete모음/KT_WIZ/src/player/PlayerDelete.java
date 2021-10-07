package player;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class PlayerDelete {
	public static void main(String[] args) {
	
		PlayerDao dao =  PlayerImp.getInst();
		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.println("삭제할 선수의 포지션은?(투수 or 타자)");
		String posi = scan.next();
		System.out.println("삭제할 선수의 이름은?");
		String name2 = scan.next();
		
		if(posi.equals("투수")) {
			
			try {
				
				int row = dao.Pitcherdelete(name2);
				
				if(row > 0) {
					System.out.println("delete complete");
				}else {
					System.out.println(name2 +" 선수는 없습니다 ");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
       if(posi.equals("타자")) {
			
			try {
				
				int row = dao.Batterdelete(name2);
				
				if(row > 0) {
					System.out.println("delete complete");
				}else {
					System.out.println(name2 +" 선수는 없습니다 ");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
       System.out.println("계속 하시겠습니까? yes or no");
       String yn = scan.next();
       if(yn.equals("no")) {
    	   break;
       }
		
		}
	}
}

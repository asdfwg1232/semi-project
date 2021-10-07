package player;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PlayerSalary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("연봉 인상 할 선수의 포지션을 고르세요");
		System.out.println("타자 - 타율 기준 / 투수 - 평균자책점 기준");
		System.out.println("타자 or 투수");
		String str4 = scan.next();
		
		if(str4.equals("타자")) {
			
			System.out.println("기준이 될 타율을 입력해주세요");
			double avg = scan.nextDouble();
			
			
			System.out.println("기존연봉에 인상할 연봉을 적어주세요");
			int salary = scan.nextInt();
			
			PlayerDao dao = PlayerImp.getInst();
			
			try {
				Batterplayer player = new Batterplayer();
				player.setSalary(salary);
				player.setAvg(avg);
				
				int result =dao.update_batter(avg,salary);
				
				if(result>0) {
					System.out.println("연봉인상");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}if(str4.equals("투수")) {
			System.out.println("기준이 될 평균자책점을 입력해주세요");
			double era = scan.nextDouble();
			
			
			System.out.println("기존연봉에 인상할 연봉을 적어주세요");
			int salary = scan.nextInt();
			
			PlayerDao dao = PlayerImp.getInst();

			try {
				Pitcherplayer player = new Pitcherplayer();
				player.setSalary(salary);
				player.setEra(era);
				
				int result =dao.update_pitcher(era,salary);
				
				if(result>0) {
					System.out.println("연봉인상");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		
		
	}

}

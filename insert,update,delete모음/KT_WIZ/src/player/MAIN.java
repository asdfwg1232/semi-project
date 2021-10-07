package player;

import java.sql.SQLException;
import java.util.Scanner;

public class MAIN {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PlayerDao dao = PlayerImp.getInst();
		
		while(true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 선수 정보 입력하기");
			System.out.println("2. 선수 정보 삭제하기");
			System.out.println("3. 선수 성적 수정하기");
			System.out.println("4. 선수 연봉 수정하기");
			System.out.println("5. 종료");
			String choice = scan.next();
			
			switch(choice) {
			case "1" :
				System.out.println("입력할 선수의 포지션은?(투수 or 타자)");
				String position = scan.next();

				if(position.equals("투수")) {
					while(true) {

						System.out.println("이름 입력");
						String name = scan.next();
						System.out.println("연봉 입력 (단위 : 만원)");
						int salary = scan.nextInt();
						System.out.println("계약금 입력 (단위 : 만원");
						int deposit = scan.nextInt();
						System.out.println("등번호 입력");
						int number = scan.nextInt();
						System.out.println("평균자책점 입력");
						double era = scan.nextDouble();
						System.out.println("피홈런 수 입력");
						int phr = scan.nextInt();
						System.out.println("승 수 입력");
						int win = scan.nextInt();
						System.out.println("패 수 입력");
						int lose = scan.nextInt();
						System.out.println("세이브 수 입력");
						int sv = scan.nextInt();
						
						Pitcherplayer pitcher = new Pitcherplayer(name, salary, deposit, position, number, era, phr, win, lose, sv);
						try {

							int a = dao.insertPitcher(pitcher);
							System.out.println(a + " insert complete");

						} catch (Exception e) {
							// TODO: handle exception
						}		
						
						System.out.println("계속 입력하시겠습니까? y or n");
						String str = scan.next();
						if(str.equals("n")) {
							break;
						}
				}
				}
//			-------------------------------------------------------------------------------------
				
				if(position.equals("타자")) {
					
					while(true) {
						System.out.println("이름 입력");
						String name1 = scan.next();
						System.out.println("연봉 입력");
						int salary1= scan.nextInt();
						System.out.println("계약금 입력");
						int deposit1 = scan.nextInt();
						System.out.println("등번호 입력");
						int number1 = scan.nextInt();
						System.out.println("타율 입력");
						double avg = scan.nextDouble();
						System.out.println("홈런 수 입력");
						int hr = scan.nextInt();
						System.out.println("도루 수 입력");
						int sb = scan.nextInt();
				
						Batterplayer batter = new Batterplayer(name1, salary1, deposit1, position, number1, avg, hr, sb);

						try {
							
							int a1 = dao.insertBatter(batter);
							System.out.println(a1 + " insert complete");

						} catch (Exception e) {
							// TODO: handle exception
						}		

						System.out.println("계속 하시겠습니까? y or n");
						String str2 = scan.next();
						if(str2.equals("n")) {
							break;
						}
					}
						
				}
				break;
			case "2" :
				
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
//					------------------------------------------
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
					
			       System.out.println("계속 하시겠습니까? y or n");
			       String yn = scan.next();
			       if(yn.equals("n")) {
			    	   break;
			       }
					
					}
				break;
			case "3" :
				
				while(true) {
					System.out.println("성적을 수정할 선수의 포지션은?(투수 or 타자)");
					String position2 = scan.next();
					System.out.println("수정하고싶은 선수 이름은?");
					String pname = scan.next();

					if(position2.equals("타자")) {
						try {
							System.out.println("수정할 타율을 입력하세요");
							double avg1 = scan.nextDouble();
							System.out.println("수정 할 홈런 수를 입력하세요");
							int hr1 = scan.nextInt();
							System.out.println("수정 할 도루 수를 입력하세요");
							int sb1 = scan.nextInt();
							
							int result = dao.updateBatter(pname, avg1, hr1, sb1);

							if(result>0) {
								System.out.println("update complete");
							}

						} catch (Exception e) {
							// TODO: handle exception
						}
					}
//					-----------------------------------------------------------
					
					if(position2.equals("투수")) {

						try {
							System.out.println("수정 할 평균자책점을 입력하세요");
							double ear1 = scan.nextDouble();
							System.out.println("수정 할 피홈런 수를 입력하세요");
							int phr1 = scan.nextInt();
							System.out.println("수정 할 승 수를 입력하세요");
							int win1 = scan.nextInt();
							System.out.println("수정 할 패 수를 입력하세요");
							int lose1 = scan.nextInt();
							System.out.println("수정 할 세이브 수를 입력하세요");
							int sv1 = scan.nextInt();

							int result1 = dao.Pitcherupdate(pname, ear1, phr1, win1, lose1, sv1);
							if(result1>0) {
								System.out.println("update complete");
							}
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

					System.out.println("계속 하시겠습니까? y or n");
					String str = scan.next();
					if(str.equals("n")) {
						break;
					}
				}
			break;
			
			case "4" :
				
				System.out.println("연봉 인상 할 선수의 포지션을 고르세요");
				System.out.println("타자 - 타율 기준 / 투수 - 평균자책점 기준");
				System.out.println("타자 or 투수");
				String str4 = scan.next();
				
				if(str4.equals("타자")) {
					
					System.out.println("기준이 될 타율을 입력해주세요");
					double avg = scan.nextDouble();
					
					
					System.out.println("기존연봉에 인상할 연봉을 적어주세요 (단위:만원");
					int salary = scan.nextInt();
					
					
					try {
						Batterplayer player = new Batterplayer();
						player.setSalary(salary);
						player.setAvg(avg);
						
						int result =dao.update_batter(avg,salary);
						
						if(result>0) {
							System.out.println("연봉인상완료");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}if(str4.equals("투수")) {
					System.out.println("기준이 될 평균자책점을 입력해주세요");
					double era = scan.nextDouble();
					
					
					System.out.println("기존연봉에 인상할 연봉을 적어주세요 (단위:만원)");
					int salary = scan.nextInt();
					

					try {
						Pitcherplayer player = new Pitcherplayer();
						player.setSalary(salary);
						player.setEra(era);
						
						int result =dao.update_pitcher(era,salary);
						
						if(result>0) {
							System.out.println("연봉인상완료");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				

				
			
		}
			

		if(choice.equals("5")) {
			
			break;
		}
		
	}

}
}
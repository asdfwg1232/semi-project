package player;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PlayerDao dao = PlayerImp.getInst();
		SelectDao daoSelect = SelectDaoImpl.getInstance();
		
		while(true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 선수 정보 입력하기");
			System.out.println("2. 선수 정보 삭제하기");
			System.out.println("3. 선수 성적 수정하기");
			System.out.println("4. 선수 연봉 수정하기");
			System.out.println("5. 선수 정보 test파일에 저장하기");
			System.out.println("6. 선수 정보 test파일 읽어오기");
			System.out.println("7. 종료");
			String choice = scan.next();
			
			switch(choice) {
			case "1" :
				System.out.println("입력할 선수의 포지션은?(투수 or 타자)");
				String position = scan.next();
				
				if(position.equals("투수")) {
					while(true) {
						
						System.out.println("name, salary, depoist, number");
						String name = scan.next();
						int salary = scan.nextInt();
						int deposit = scan.nextInt();
						int number = scan.nextInt();
						System.out.println("era입력");
						double era = scan.nextDouble();
						System.out.println(" phr");
						int phr = scan.nextInt();
						System.out.println("win");
						int win = scan.nextInt();
						System.out.println("lose입력");
						int lose = scan.nextInt();
						System.out.println("sv 입력");
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
						System.out.println("name, salary, depoist, number");
						String name1 = scan.next();
						int salary1= scan.nextInt();
						int deposit1 = scan.nextInt();
						int number1 = scan.nextInt();
						System.out.println("avg, hr, sb 입력");
						double avg = scan.nextDouble();
						int hr = scan.nextInt();
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
							System.out.println("수정하고싶은 avg,hr,sb의 값을 입력하세요");
							double avg1 = scan.nextDouble();
							int hr1 = scan.nextInt();
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
							System.out.println("수정하고싶은 era,phr,win,lose,sv 의 값을 입력하세요");
							double ear1 = scan.nextDouble();
							int phr1 = scan.nextInt();
							int win1 = scan.nextInt();
							int lose1 = scan.nextInt();
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
					
					
					System.out.println("기존연봉에 인상할 연봉을 적어주세요");
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
					
					
					System.out.println("기존연봉에 인상할 연봉을 적어주세요");
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
				
				
				
				
			case "5" :	
				
				System.out.println("타자 or 투수 중 어느걸 파일에 저장할지 골라주세요.");
				String str5 = scan.next();
				System.out.println("선수정보를 저장하실 파일명을 입력해주세요.");
				String filename = scan.next();
				String filepath = "c:\\test\\";
				if(str5.equals("타자")) {
					try {
						List<Batterplayer> playerList = daoSelect.PlayerYears_batterFindAll(2021);
						for(Batterplayer player : playerList) {
							System.out.println("타자 관련 파일을 작성 완료했습니다.");
						}
						daoSelect.writeBatterplayerFile(filepath, filename, playerList);
					}catch(ClassNotFoundException e) {
						e.printStackTrace();
					}catch(SQLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(str5.equals("투수")) {
					try {
						List<Pitcherplayer> playerList = daoSelect.PlayerYars_pitcherFindAll(2021);
						for(Pitcherplayer player : playerList) {
							System.out.println("투수 관련 파일을 작성 완료했습니다.");
						}
						daoSelect.writePitcherplayerFile(filepath, filename, playerList);
					}catch(ClassNotFoundException e) {
						e.printStackTrace();
					}catch(SQLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
				
			//-----------------test파일 -----------------------------------	
			case "6" :
				SelectDaoImpl di= new SelectDaoImpl();
				Batterplayer bp = new Batterplayer();
				Pitcherplayer pp = new Pitcherplayer();
				System.out.println("선수정보가 저장된 파일명을 입력해주세요.");
				String filename1 = scan.next();
				String filepath1 = "c:\\test\\";
				
    			System.out.println("해당 파일이 타자 or 투수 관련 파일인가요?");
				String ans = scan.next();
				while(true) {
					if(ans.equals("타자")) {
						try {
							di.setInfoList_Batter(daoSelect.readFile_batter(new File(filepath1, filename1)));
							System.out.println(di.infoList_batter+"\n");
						}catch(ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
					}else if(ans.equals("투수")) {				
							try {
								di.setInfoList_pitcher(daoSelect.readFile_pitcher(new File(filepath1, filename1)));
								System.out.println(di.infoList_pitcher+"\n");
							}catch(ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
					}
					break;
				}
			}

			
			if(choice.equals("7")) {
				
				break;
			}
			
		}
		
	}
}

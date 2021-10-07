package down;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import player.PlayerDao;
import player.PlayerImp;

public class MAIN2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SelectDao dao = SelectDaoImpl.getInstance();
		
		while(true) {
			
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 컬럼을 기준으로 전체 선수 정보 조회하기");
			System.out.println("2. 원하는 만큼선수정보 조회하기");
			System.out.println("3. 선수의 연봉을 조회하기");
			System.out.println("4. 종료");
			String select = scan.next();
			
			switch(select) {
			
			case "1" :
				
				System.out.println("어떤 포지션을 조회 하시겠습니까?");
				System.out.println("타자 or 투수");
				String str = scan.next();
				
				if(str.equals("타자")) {
					String[] columns = {"avg", "hr", "sb"};
					
					System.out.println("기준이 될 컬럼을 번호로 선택해주세요");
					System.out.println("avg-타율, hr-홈런, sb-도루");
					for(int i =0; i<columns.length;i++) {
						System.out.println(i+". "+columns[i]);
					}
					
					int columnNum =scan.nextInt();
					
					System.out.println("정렬방식을 번호로 선택하세요");
					System.out.println("1.오름차순");
					System.out.println("2.내림차순");
					
					int orderByNum = scan.nextInt();
					String orderBy = (orderByNum == 1 ? "asc" : "desc");
					
					
					try {
						List<Batterplayer> btList = dao.batterOrderBy(columns[columnNum], orderBy);
						
						for(Batterplayer batter : btList) {
							System.out.println(batter);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}if(str.equals("투수")) {
					String[] columns = {"era", "phr", "win","lose","sv"};
					
					System.out.println("기준이 될 컬럼을 번호로 선택해주세요");
					System.out.println("era-평균자책점, phr-피홈런, win-승, lose-패, sv-세이브");
					for(int i =0; i<columns.length;i++) {
						System.out.println(i+". "+columns[i]);
					}
					
					int columnNum =scan.nextInt();
					
					System.out.println("정렬방식을 번호로 선택하세요");
					System.out.println("1.오름차순");
					System.out.println("2.내림차순");
					
					int orderByNum = scan.nextInt();
					String orderBy = (orderByNum == 1 ? "asc" : "desc");
					
					
					try {
						List<Pitcherplayer> pcList = dao.pitcherOrderBy(columns[columnNum], orderBy);
						
						for(Pitcherplayer pitcher : pcList) {
							System.out.println(pitcher);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			break;
			
			case "2" :
				
				System.out.println("어떤 포지션을 조회 하시겠습니까?");
				System.out.println("타자 or 투수");
				String str2 = scan.next();
				
				if(str2.equals("타자")) {
					
					String[] columns = {"avg", "hr", "sb"};
					
					System.out.println("조회할 기록을 번호로 선택하세요");
					System.out.println("avg-타율, hr-홈런, sb-도루");
					for(int i =0; i<columns.length;i++) {
						System.out.println(i+". "+columns[i]);
					}
					
					int columnNum =scan.nextInt();
					
					System.out.println("정렬방식을 번호로 선택하세요");
					System.out.println("1.오름차순");
					System.out.println("2.내림차순");
					
					int orderByNum = scan.nextInt();
					String orderBy = (orderByNum == 1 ? "asc" : "desc");
					
					System.out.println("조회할 선수 수를 입력하세요");
					int num = scan.nextInt();
					
					
					try {
						List<Batterplayer> btList = dao.batterFindLimit(columns[columnNum], orderBy, num);
						
						for(Batterplayer batter : btList) {
							System.out.println(batter);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}if(str2.equals("투수")){
					String[] columns = {"era", "phr", "win","lose","sv"};
					
					System.out.println("조회할 기록을 번호로 선택하세요");
					System.out.println("era-평균자책점, phr-피홈런, win-승, lose-패, sv-세이브");
					for(int i =0; i<columns.length;i++) {
						System.out.println(i+". "+columns[i]);
					}
					
					int columnNum =scan.nextInt();
					
					System.out.println("정렬방식을 번호로 선택하세요");
					System.out.println("1.오름차순");
					System.out.println("2.내림차순");
					
					int orderByNum = scan.nextInt();
					String orderBy = (orderByNum == 1 ? "asc" : "desc");
					
					System.out.println("조회할 선수 수를 입력하세요");
					int num = scan.nextInt();
					
					
					
					try {
						List<Pitcherplayer> pcList = dao.pitcherFindLimit(columns[columnNum], orderBy,num);
						
						for(Pitcherplayer pitcher : pcList) {
							System.out.println(pitcher);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
			break;
			case "3" :
				

				System.out.println("타자 연봉 top10, 투수 연봉 top5 조회");
				System.out.println("타자 or 투수");
				String str5 = scan.next();
				
				if(str5.equals("타자")) {
					
					try {
						List<Batterplayer> btList = dao.bSalaryLimit();
						
						for(Batterplayer batter : btList) {
							System.out.println(batter);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}if(str5.equals("투수")) {
					
					try {
						List<Pitcherplayer> pcList = dao.pSalaryLimit();
						
						for(Pitcherplayer pitcher : pcList) {
							System.out.println(pitcher);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				break;
			}
			
			
			
			
			
			if(select.equals("4")) {
					
					break;
				}
				
	
			
			System.out.println();
			System.out.println("더 조회 하시겠습니까?");
			System.out.println("y or n");
			String yn =scan.next();
			if(yn.equals("n")) {
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}

}

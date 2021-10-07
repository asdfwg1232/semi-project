package player;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args) {
		
		PlayerDao dao = PlayerImp.getInst();
		Scanner scan = new Scanner(System.in);
		
		//값 insert하기
		System.out.println("투수 /  타자 중 어느선수에 입력?");
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
				
				System.out.println("계속 하시겠습니까? y or n");
				String str = scan.next();
				if(str.equals("n")) {
					break;
				}
		}
		}
//	-------------------------------------------------------------------------------------
		
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
		}

	}


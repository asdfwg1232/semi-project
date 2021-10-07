package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Update {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		PlayerDao dao = PlayerImp.getInst();

		while(true) {
			System.out.println("투수 /  타자 중 어느 포지션의 선수를 수정?");
			String position = scan.next();
			System.out.println("수정하고싶은 선수 이름은?");
			String pname = scan.next();

			if(position.equals("타자")) {
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

			if(position.equals("투수")) {

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

			System.out.println("더 하시겠습니까? y or n");
			String str = scan.next();
			if(str.equals("n")) {
				break;
			}
		}
		
	}
}

package ktyear;

import java.util.List;
import java.util.Scanner;

import down.SelectDao;
import down.SelectDaoImpl;

public class MAIN3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RecordDao dao = RecordImp.getinst();

		while(true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. kt팀의 2015~2020년까지의 투수/타자별 성적 조회");
			System.out.println("2. 2015~2020년중의 연도를 선택하여 성적 조회");
			System.out.println("3.  종료");
			String select = scan.next();

			switch(select) {

			case "1" :
				System.out.println("투수, 타자중 어떤 데이터를 보시겠습니까?");
				String choice = scan.next();

				if(choice.equals("투수")) {
					try {

						List<KTWIZ_Pitcher> list = dao.pitcherAll();
						System.out.println(list);

					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				if(choice.equals("타자")) {
					try {
						List<KTWIZ_Batter> list2 = dao.batterAll();
						System.out.println(list2);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				break;

			case "2" :
				System.out.println();
				System.out.println("투수, 타자중 어떤 데이터를 보시겠습니까?");
				String choi2 = scan.next();

				if(choi2.equals("투수")) {
					try {
						System.out.println("찾고자 하는 연도를 입력하세요");
						int year = scan.nextInt();


						List<KTWIZ_Pitcher> list3 = dao.pitcherRecord(year);

						System.out.println(list3);

					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				if(choi2.equals("타자")) {
					try {
						System.out.println("찾고자 하는 연도를 입력하세요");
						int year1 = scan.nextInt();

						List<KTWIZ_Batter> list4 =  dao.batterRecord(year1);

						System.out.println(list4);

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				break;
			}


			if(select.equals("3")) {

				break;
			}




		}
	}

}

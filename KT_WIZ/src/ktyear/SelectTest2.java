package ktyear;

import java.util.List;
import java.util.Scanner;

public class SelectTest2 {
	public static void main(String[] args) {

		RecordDao dao = RecordImp.getinst();

		Scanner scan = new Scanner(System.in);
		System.out.println("투수, 타자중 어떤 데이터를 보시겠습니까?");
		String choi2 = scan.next();
		
		if(choi2.equals("투수")) {
		try {
			System.out.println("찾고자 하는 연도와 기록을 입력하세요");
			int year = scan.nextInt();
			String column = scan.next();
			
			List<KTWIZ_Pitcher> list3 = dao.pitcherRecord(year, column);
			
			System.out.println(list3);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		
		if(choi2.equals("타자")) {
		try {
			System.out.println("찾고자 하는 연도와 기록을 입력하세요");
			int year1 = scan.nextInt();
			String column1 = scan.next();
			
			List<KTWIZ_Batter> list4 =  dao.batterRecord(year1, column1);
			
			System.out.println(list4);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		}
	}

}

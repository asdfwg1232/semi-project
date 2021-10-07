package ktyear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectTest1 {
	public static void main(String[] args) {
		RecordDao dao = RecordImp.getinst();
		
		Scanner scan = new Scanner(System.in);
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
	}

}

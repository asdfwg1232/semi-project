package ktyear;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Read4 {
	
	public static void main(String[] args) {
		String filename = "src/ktyear/Record.txt";
		File file = new File(filename);
		
		BufferedReader in = null;
		try {
			
			in = new BufferedReader(new FileReader(file));
//			int d = -1;
//			while((in.read()) != -1) {
//				System.out.println(d);
//				
//			}
			String line = in.readLine();
			List<KTWIZ_Pitcher> ktp = new ArrayList<KTWIZ_Pitcher>();
			
			while((line) != null) {
				
				String[] s = line.split(", ");
				
				KTWIZ_Pitcher ktpit = new KTWIZ_Pitcher();
				
				ktpit.setYear(Integer.parseInt(s[0]));
				ktpit.setRank(Integer.parseInt(s[1]));
				ktpit.setEra(Double.parseDouble(s[2]));
				ktpit.setWin(Integer.parseInt(s[3]));
				ktpit.setLose(Integer.parseInt(s[4]));
				ktpit.setSv(Integer.parseInt(s[5]));
				
				ktp.add(ktpit);
			}
			System.out.println(ktp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

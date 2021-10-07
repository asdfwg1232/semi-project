package ktyear;

public class KTWIZ_Pitcher {
	
	private int year;
	private int rank;
	private double era;
	private int phr;
	private int win;
	private int lose;
	private int sv;
	
	public KTWIZ_Pitcher() {}

	public KTWIZ_Pitcher(int year, int rank, double era, int phr, int win, int lose, int sv) {
		super();
		this.year = year;
		this.rank = rank;
		this.era = era;
		this.phr = phr;
		this.win = win;
		this.lose = lose;
		this.sv = sv;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	public int getPhr() {
		return phr;
	}

	public void setPhr(int phr) {
		this.phr = phr;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getSv() {
		return sv;
	}

	public void setSv(int sv) {
		this.sv = sv;
	}

	@Override
	public String toString() {
		return "KTWIZ_Pitcher [year=" + year + ", rank=" + rank + ", era=" + era + ", phr=" + phr + ", win=" + win
				+ ", lose=" + lose + ", sv=" + sv + "]";
	}
	
	

}

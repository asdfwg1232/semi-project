package ktyear;

public class KTWIZ_Batter {
	
	private int year;
	private int rank;
	private double avg;
	private int hr;
	private int run;//득점
	private int hit; //안타
	
	public KTWIZ_Batter() {}

	public KTWIZ_Batter(int year, int rank, double avg, int hr, int run, int hit) {
		super();
		this.year = year;
		this.rank = rank;
		this.avg = avg;
		this.hr = hr;
		this.run = run;
		this.hit = hit;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "KTWIZ_Batter [year=" + year + ", rank=" + rank + ", avg=" + avg + ", hr=" + hr + ", run=" + run
				+ ", hit=" + hit + "]";
	}
	
	

}

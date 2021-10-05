package player;

public class Batter { //타자 클래스
	//타자 타율- avg 홈런 -hr 도루 -sb
	
	private double avg;
	private int hr;
	private int sb;
	
	//생성자 / 기본생성자 / getter setter / to string

	public Batter() {}

	public Batter(double avg, int hr, int sb) {
		super();
		this.avg = avg;
		this.hr = hr;
		this.sb = sb;
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

	public int getSb() {
		return sb;
	}

	public void setSb(int sb) {
		this.sb = sb;
	}

	@Override
	public String toString() {
		return "Batter [avg=" + avg + ", hr=" + hr + ", sb=" + sb + "]";
	}
	
	
	
	

}

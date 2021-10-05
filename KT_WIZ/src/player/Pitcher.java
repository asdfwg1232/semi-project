package player;

public class Pitcher { //투수 클래스
//투수 평자 -era 피홈런 - phr 승 -w 패 -l 세이브 -sv
	private double era;
	private int phr;
	private int win;
	private int lose;
	private int sv;
	
	//생성자 / 기본생성자 / getter setter / to string
	public Pitcher () {}

	public Pitcher(double era, int phr, int win, int lose, int sv) {
		super();
		this.era = era;
		this.phr = phr;
		this.win = win;
		this.lose = lose;
		this.sv = sv;
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
		return "Pitcher [era=" + era + ", phr=" + phr + ", win=" + win + ", lose=" + lose + ", sv=" + sv + "]";
	}
	
	
	
}

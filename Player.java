package players;

public class Player {
	
	private String name; //이름
	private double ba; //타율
	private int atbat; //타석
	private int gamenum; //경기수
	private int hr; // 홈런
	
	//기본생성자, 생성자
	public Player() {}
	
	public Player(String name, double ba, int atbat, int gamenum, int hr) {
		super();
		this.name = name;
		this.ba = ba;
		this.atbat = atbat;
		this.gamenum = gamenum;
		this.hr = hr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBa() {
		return ba;
	}

	public void setBa(double ba) {
		this.ba = ba;
	}

	public int getAtbat() {
		return atbat;
	}

	public void setAtbat(int atbat) {
		this.atbat = atbat;
	}

	public int getGamenum() {
		return gamenum;
	}

	public void setGamenum(int gamenum) {
		this.gamenum = gamenum;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", ba=" + ba + ", atbat=" + atbat + ", gamenum=" + gamenum + ", hr=" + hr + "]";
	}
	
	
	

}

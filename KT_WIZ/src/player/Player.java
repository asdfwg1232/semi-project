package player;

public class Player {
	
	private int salary; // 연봉
	private int deposit ; // 계약금
	private int year ; //xx년생
	private int number ; //등번호
	private Pitcher pitcher; //투수 클래스
	private Batter batter; //타자 클래스
	
	//생성자 / 기본생성자 / getter setter / to string
	public Player() {}

	public Player(int salary, int deposit, int year, int number, Pitcher pitcher, Batter batter) {
		super();
		this.salary = salary;
		this.deposit = deposit;
		this.year = year;
		this.number = number;
		this.pitcher = pitcher;
		this.batter = batter;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Pitcher getPitcher() {
		return pitcher;
	}

	public void setPitcher(Pitcher pitcher) {
		this.pitcher = pitcher;
	}

	public Batter getBatter() {
		return batter;
	}

	public void setBatter(Batter batter) {
		this.batter = batter;
	}

	@Override
	public String toString() {
		return "Player [salary=" + salary + ", deposit=" + deposit + ", year=" + year + ", number=" + number
				+ ", pitcher=" + pitcher + ", batter=" + batter + "]";
	}
	
	
	
	

}

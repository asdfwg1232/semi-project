public class PlayerDto_pitcher {
	String name;
	int salary;
	int deposit;
	String position;
	int number;
	double era;
	int phr;
	int win;
	int lose;
	int sv;
	
	
	
	public PlayerDto_pitcher(String name, int salary, int deposit, String position, int number,double era, int phr,
			int win, int lose, int sv) {
		super();
		this.name = name;
		this.salary = salary;
		this.deposit = deposit;
		this.position = position;
		this.number = number;
		this.era = era;
		this.phr = phr;
		this.win = win;
		this.lose = lose;
		this.sv = sv;
	}
	public PlayerDto_pitcher(int salary, double ans) {
		this.salary = salary;
	}
		
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
		return "PlayerDto_pitcher [number=" + number + ", name=" + name + ", salary=" + salary + ", deposit=" + deposit
				+ ", position=" + position + ", era=" + era + ", phr=" + phr + ", win=" + win + ", lose=" + lose
				+ ", sv=" + sv + "]";
	}
	
	

}

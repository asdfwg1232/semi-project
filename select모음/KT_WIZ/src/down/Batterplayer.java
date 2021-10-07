package down;


public class Batterplayer {

	private String name; //이름
	private int salary; // 연봉
	private int deposit ; // 계약금
	private String position ; //포지션
	private int number ; //등번호
	
	//타자 타율- avg 홈런 -hr 도루 -sb
	private double avg;
	private int hr;
	private int sb;

	//기본생성자 생성자
	
	public Batterplayer() {}

	public Batterplayer(String name, int salary, int deposit, String position, int number, double avg, int hr, int sb) {
		super();
		this.name = name;
		this.salary = salary;
		this.deposit = deposit;
		this.position = position;
		this.number = number;
		this.avg = avg;
		this.hr = hr;
		this.sb = sb;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
		return "Batterplayer [name=" + name + ", salary=" + salary + ", deposit=" + deposit + ", position=" + position
				+ ", number=" + number + ", avg=" + avg + ", hr=" + hr + ", sb=" + sb + "]";
	}
	
	
	
	
}

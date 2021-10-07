package player;



public class Pitcherplayer {
		private String name; //이름
		private int salary; // 연봉
		private int deposit ; // 계약금
		private String position ; //포지션
		private int number ; //등번호
		
		//투수 평자 -era 피홈런 - phr 승 -w 패 -l 세이브 -sv
		private double era;
		private int phr;
		private int win;
		private int lose;
		private int sv;
		
		//기본생성자 생성자
		public Pitcherplayer() {}

		public Pitcherplayer(String name, int salary, int deposit, String position, int number, double era, int phr,
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
			return "Pitcherplayer [name=" + name + ", salary=" + salary + ", deposit=" + deposit + ", position="
					+ position + ", number=" + number + ", era=" + era + ", phr=" + phr + ", win=" + win + ", lose="
					+ lose + ", sv=" + sv + "]";
		}
		
		

}

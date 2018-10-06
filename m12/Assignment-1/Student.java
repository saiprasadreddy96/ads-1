class Student {
	private String sname, dob, category;
	private int m1, m2, m3, tm;
	Student(String sname, String dob, int m1, int m2, int m3, int tm, String category) {
		this.sname = sname;
		this.dob = dob;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.tm = tm;
		this.category = category;
	}
	public String getname() {
		return sname;
	}
	public int getm2() {
		return m2;
	}
	public int getm3() {
		return m3;
	}
	public int gettm() {
		return tm;
	}
	public String getdob() {
		return dob;
	}
	public String getcategory() {
		return category;
	}
	public String toString() {
		return this.getname() + "," + this.gettm() + "," + this.getcategory();
	}

}
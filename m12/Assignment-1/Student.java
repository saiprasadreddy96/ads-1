/**.
 * Class for student.
 */
class Student {
	private String sname, dob, category;
	private int m1, m2, m3, tm;
	/**.
	 * Constructs the object.
	 *
	 * @param      sname1     The sname 1
	 * @param      dob1       The dob 1
	 * @param      m11        The m 11
	 * @param      m21        The m 21
	 * @param      m31        The m 31
	 * @param      tm1        The time 1
	 * @param      category1  The category 1
	 */
	Student(final String sname1, final String dob1, final int m11, final int m21, final int m31, final int tm1, final String category1) {
		this.sname = sname1;
		this.dob = dob1;
		this.m1 = m11;
		this.m2 = m21;
		this.m3 = m31;
		this.tm = tm1;
		this.category = category1;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getname() {
		return sname;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getm2() {
		return m2;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getm3() {
		return m3;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int gettm() {
		return tm;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getdob() {
		return dob;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getcategory() {
		return category;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.getname() + "," + this.gettm()
		+ "," + this.getcategory();
	}

}
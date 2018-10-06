/**.
 * Class for student.
 */
class Student {
	private String sname, dob, category;
	private int m1, m2, m3, tm;
	/**.
	 * Constructs the object.
	 *
	 * @param      sname     The sname
	 * @param      dob       The dob
	 * @param      m1        The m 1
	 * @param      m2        The m 2
	 * @param      m3        The m 3
	 * @param      tm        The time
	 * @param      category  The category
	 */
	Student(final String sname, final String dob, final int m1, final int m2, final int m3, final int tm, final String category) {
		this.sname = sname;
		this.dob = dob;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.tm = tm;
		this.category = category;
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
		return this.getname() + "," + this.gettm() + "," + this.getcategory();
	}

}
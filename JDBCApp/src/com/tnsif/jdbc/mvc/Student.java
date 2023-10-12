//Program to define Student entity
package com.tnsif.jdbc.mvc;

public class Student {
	private int rollNo;
	private String sname;
	private float per;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}

	public Student(int rollNo, String sname, float per) {
		this.rollNo = rollNo;
		this.sname = sname;
		this.per = per;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sname=" + sname + ", per=" + per + "]";
	}

}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Employee.java
 * 2016��1��22��
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package streams;

import java.util.List;

/**
 * ʵ�ֹ��ܣ� 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2016��1��22��        ����         starqiu@mail.ustc.edu.cn	    �½���<br /></p>
 *
 */
public class Employee {
	private String name;
	private String city;
	private int numSales;
	public Employee() {
	}
	public Employee(String name,String city,int numSales) {
		this.name = name;
		this.city = city;
		this.numSales = numSales;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumSales() {
		return numSales;
	}
	public void setNumSales(int numSales) {
		this.numSales = numSales;
	}
	

}


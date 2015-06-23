/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * People.java
 * 2015年6月23日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年6月23日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class People {
	
	private String name;
	private int age;
	
	public People(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public int  ageDifference(People p){
		return this.getAge() - p.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s - %d", name,age);
	}

}


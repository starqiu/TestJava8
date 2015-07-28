/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestTryCatch.java
 * 2015年7月21日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package tryCatch;

/**
 * 实现功能：
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015年7月21日 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 *
 */
public class TestTryCatch {

	public static void main(String[] args) {

		System.out.println("i的值为。。。" + new TestTryCatch().testPrimive());
		System.out.println("str的值为。。。" + new TestTryCatch().testString());
		System.out.println("Book的值为。。。" + new TestTryCatch().testReference());

	}

	private int testPrimive() {

		int i = 1;

		try {

			return i;

		} finally {

			++i;

			System.out.println("finally is Executed…");

		}

	}
	
	
	private String testString() {
		
		String str= "Hello world";
		
		try {
			
			return str;
			
		} finally {
			
			str = str + "123";
//			str = (str + "123").intern();
			
			System.out.println("finally is Executed…");
			
		}
		
	}
	
	
	private  Book testReference() {
		
		Book book = new Book(123, "Java 8 : functional programing");
		
		try {
			
			return book;
			
		} finally {
			
			book.setId(567);
			
			System.out.println("finally is Executed…");
			
		}
		
	}

}

class Book {
	private int id;
	private String name;
	

	public Book() {
	}
	public Book(int id, String name){
		this();
		this.id = id;
		this.name = name;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + " "+name;
	}
	
}

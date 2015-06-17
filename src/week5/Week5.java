/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Week5.java
 * 2015年6月15日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package week5;

import java.util.Scanner;

/**
 * 实现功能： 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015年6月15日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
 *
 */
public class Week5 {
	
	public int field1 = 1;
	public String field2 ="init";
	
	public Week5(){
		System.out.println(this.field1 + this.field2);
		this.field1 =2;
		this.field2 ="constructor";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 构造方法的执行过程遵照以下步骤：
		 * 调用本类或父类的构造方法，直至最高一层（Object）
		 *   按照声明顺序执行字段的初始化赋值
		 * 执行构造函数中的各语句
		 *简单地说：先父类构造，再本类成员赋值，最后执行构造方法中的语句。
		 */
		Week5 week5 = new Week5();
		System.out.println(week5.field1 + week5.field2);
		
		Person person = new Student("Li Ming", 18, "PKU");
	
		//try-with-resources,auto-close,so we needn't to input
		try(Scanner sc = new Scanner(System.in)){};
		System.out.println("hello");
		
		Integer m = 10;
		Integer n = 10;
		System.out.println(m==n);
		
		Integer p =200;
		Integer q =200;
		System.out.println(p==q);
		
	}
	
	static class Person
	{
		String name="Star"; 
		int age=-1;
		Person( String name, int age ){
			sayHello();
			this.name=name; this.age=age; 
			sayHello();
		}
		void sayHello(){
			System.out.println( "A Person, name: " + name + ", age: "+ age );
		}
	}

	static class Student extends Person
	{
		String school="NK";
		Student( String name, int age, String school ){
			super( name, age );
			sayHello();
			this.school = school;
			sayHello();
		}
		void sayHello(){
			System.out.println( "A Student, name:" + name + ", age: "+ age + ", school: " + school );
		}
	}


}


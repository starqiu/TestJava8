/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Week3.java
 * 2015年6月12日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package week3;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;


/**
 * 实现功能： 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015年6月12日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
 *
 */
public class Week3 {
	
	public static void main(String[] args) {
		Week3 week3 = new Week3();
		Person p1 = new Person(5);
		Person p2 = p1;
		p2.setAge(3);
		
		init(p1);
		System.out.println(p1.age);
		
		int a=2; 
		int b=a++ + ++a;;
		System.out.println("a="+a+" b="+b);
		
		label1:for (int i = 0; i < 5; i++) {
			label2:for (int j = 0; j < 6; j++) {
				label3:for (int j2 = 0; j2 < 7; j2++) {
					if (j2 == 3) {
						break label1;
					}
					System.out.println(i+" "+j + " "+j2);
				}
			}
		}
		
		System.out.println(new Student(5).age);
		System.out.println(sum());
	}
	
	public static void init(Person p){
		p = new Person(7);
	}
	
	static int sum(int... nums){
		int result = 0;
		System.out.println(nums);
		for (int i : nums) {
			result += i;
		}
		return result;
	}

	static class Student{
		int age;
		
		public Student(int age){
			this.age = age;
		}
		public void setAge(int age){
			this.age = age;
		}
	}
	
}


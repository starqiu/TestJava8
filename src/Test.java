import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Test.java
 * 2015年7月2日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能：
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015年7月2日 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 *
 */
public class Test {
	private static final List<String> names = new ArrayList<String>(){{
		add("john");
		System.out.println(names);
	}};
	
	
	public static void main(String[] args) {
		Integer[] arr = { 1, 4, 2, 5, 2 };
		Stream.of(arr).forEach(System.out::println);
		List<People> peoples = new ArrayList<People>();
		People people = new People("starqiu", 27);
		peoples.add(people);

		people.setAge(18);

		System.out.println(peoples.get(0).getAge());

		int a = 5;
		int b = 10;
		int c = a++ + b;

		System.out.printf("%d %d %d\n", a, b, c);

		Child child = new Child();

		System.out.println(((Father) child).getName());
		
		MyClass m1 = new MyClass();
		MyClass m2 = new MyClass();
		
		m1.name = m2.name ="m1";
		callme(m1,m2);
		System.out.println(m1.name + " & " + m2.name);
		
		names.forEach(System.out::println);
		
		Abs abs = new Abs() {
		};
		
		abs.name = "hello";
		System.out.println(abs.name);
	}
	
	private static void callme(MyClass... m){
		m[0] = m[1];
		m[1].name  = "new name";
	}
}

abstract class Abs {
	public String name;
}

class MyClass {
	public String name;
}


abstract class Person {

	public String m_name = "God";

	public  String getName() {
		System.out.println(1);
		return m_name;

	}

}

class Father extends Person {

	public String m_name = "Father";

	public String getName() {

		System.out.println(2);
		return super.m_name;

	}

}

class Child extends Father {

	public String getName() {
		System.out.println(3);
		return m_name;

	}
}

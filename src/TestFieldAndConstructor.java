import java.util.Arrays;
import java.util.Random;


/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestFieldAndConstructor.java
 * 2015��5��29��
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * ʵ�ֹ��ܣ� 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015��5��29��        ����         starqiu@mail.ustc.edu.cn	    �½���<br /></p>
 *
 */
public class TestFieldAndConstructor {
	
	private String field = init();
	
	public TestFieldAndConstructor(){
		System.out.println("constructor");
	}
	
	public String init(){
		System.out.println("init");
		return "init";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		init
//		constructor
		new TestFieldAndConstructor();
		
//		throw Exception
//		Random random = new Random();
//		random.nextInt(-20);
		
//		null
//		int[] a = null;
//		System.out.println(Arrays.toString(a));
		String doubleStr = "5.678";
		System.out.println(Integer.valueOf(doubleStr.substring(0, doubleStr.indexOf('.'))));
		int a;
		System.out.println(1>2?(a =3):(a = 5));
		System.out.println(a);
	}

}


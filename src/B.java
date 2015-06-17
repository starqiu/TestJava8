import java.io.File;

import javax.activation.FileDataSource;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * B.java
 * 2015年5月19日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015年5月19日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
 *
 */
public class B extends A {

	public String field =" hello " ;
	
	public B(String field){
		this.field = field;
	}
	/* 
	 * @see A#fun1()
	 */
	@Override
	public int fun1(B b) {
		System.out.println(b.field);
		return 0;
	}
	
	public static void main(String[] args) {
		new B("world").fun1(new B("param"));
		System.out.println((""+File.separator).equals(File.separator));
	}

}


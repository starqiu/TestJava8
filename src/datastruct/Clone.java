/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Clone.java
 * 2015年8月5日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

import java.util.Date;

/**
 * 实现功能： 深拷贝 浅拷贝
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年8月5日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Clone {
	
	public static void main(String[] args)  throws Exception{
		ShallowCopy shallowCopy = new ShallowCopy();
		Date date = new Date();
		
		shallowCopy.beginDate = date;
		ShallowCopy shallowCopy1 =(ShallowCopy) (shallowCopy.clone());
		
		System.out.println( "date="+ date);
		System.out.println( " shallowCopy date="+ shallowCopy.beginDate);
		System.out.println( " shallowCopy1 date="+ shallowCopy1.beginDate);
		
		shallowCopy1.beginDate.setMonth(3);
		System.out.println( "date="+ date);
		System.out.println( " shallowCopy date="+ shallowCopy.beginDate);
		System.out.println( " shallowCopy1 date="+ shallowCopy1.beginDate);
		
		System.out.println("=================");
		
		DeepCopy deepCopy = new DeepCopy();
		Date date1 = new Date();
		deepCopy.beginDate = date1;
		DeepCopy deepCopy1 =(DeepCopy) (deepCopy.clone());
		
		System.out.println( "date="+ date1);
		System.out.println( " deepCopy date="+ deepCopy.beginDate);
		System.out.println( " deepCopy1 date="+ deepCopy1.beginDate);
		
		deepCopy1.beginDate.setMonth(3);
		System.out.println( "date="+ date1);
		System.out.println( " deepCopy date="+ deepCopy.beginDate);
		System.out.println( " deepCopy1 date="+ deepCopy1.beginDate);
	}
}

class ShallowCopy implements Cloneable{
	public Date beginDate;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class DeepCopy implements Cloneable{
	public Date beginDate;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		DeepCopy deepCopy = (DeepCopy)super.clone();
		deepCopy.beginDate = (Date)deepCopy.beginDate.clone();
		return deepCopy;
	}
}


/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * AddWithoutCondition.java
 * 2015年7月29日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月29日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
/**
 * @author 邱星
 */
public class AddWithoutCondition {

	public static  int n = 0;
	public static int sum = 0;
	public final int f = 0;
	private int m =1;
	
	
	
	public int getM(){
		return m;
	}
	public AddWithoutCondition(){
		n++;
		sum += n;
		System.out.println("...");
	}
	
	public static void reset(){
		n = 0;
		sum = 0;
	}
	
	public  static int getSum(){
		System.out.println(sum);
		return sum;
	}
	
	/**
	 * this is wrong,对象类型的数组虽然被默认初始化了，但是并没有调用其构造函数。
	 * 也就是说：Car[] myCar = new Car[10];只创建了一个myCar数组对象！并没有创建Car对象的任何实例！
	 * @param m
	 * @return
	 */
	public static int sum_solution1(int m){
		AddWithoutCondition.reset();
		AddWithoutCondition[] a = new AddWithoutCondition[m] ;
		return AddWithoutCondition.getSum();
	}
	
	/**
	 * 利用短路运算符
	 * @param n
	 * @return
	 */
	public static int sum_solution2(int n){  
        int re=0;  
        boolean whatever=false;  
        int a=-1;  
        whatever=(n!=0)&&(a==(re=sum_solution2(n-1)));  
        return re+n;  
    }  
	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		AddWithoutCondition.sum_solution1(4);
		AddWithoutCondition[] a  = new AddWithoutCondition[5];
		System.out.println(a[0].getM());
//		System.out.println(AddWithoutCondition.sum_solution2(4));
	}

}


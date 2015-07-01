/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * HelloWorld.java
 * 2015年7月1日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package concurrency;

/**
 * 实现功能： 
 * <p>
 * date	        author            email		           notes<br />
 * ----------------------------------------------------------------<br />
 *2015年7月1日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
 *
 */
public class HelloWorld {
	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(()->System.out.println("Hello new thread"));
		myThread.start();
//		Thread.yield();
		Thread.sleep(1);
		System.out.println("Hello Main thread");
		myThread.join();
	}

}


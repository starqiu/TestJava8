/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Local.java
 * 2015年7月17日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package callback;

/**
 * 实现功能： Java回调函数机制 <br >
 * http://blog.csdn.net/gao_chun/article/details/46895835
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月17日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
/**
 * 简单本地发送异步消息的类
 */
public class Local implements CallBack, Runnable {

	/**
	 * 远程接收消息的类，模拟point-to-point
	 */
	private Remote remote;

	/**
	 * 发送出去的消息
	 */
	private String message;

	public Local(Remote remote, String message) {
		super();
		this.remote = remote;
		this.message = message;
	}

	/**
	 * 发送消息
	 */
	public void sendMessage() {
		/** 当前线程的名称 **/
		System.out.println(Thread.currentThread().getName());
		System.out.println("I am working !");
		/** 创建一个新的线程发送消息 **/
		Thread thread = new Thread(this);
		thread.start();
		/** 当前线程继续执行 **/
		System.out.println("Message has been sent by Local~!");
		System.out.println("Continue working");
	}

	/**
	 * 发送消息后的回调函数
	 */
	public void execute(Object... objects) {
		/** 打印返回的消息 **/
		System.out.println(objects[0]);
		/** 打印发送消息的线程名称 **/
		System.out.println(Thread.currentThread().getName());
		/** 中断发送消息的线程 **/
		Thread.interrupted();
	}

	public static void main(String[] args) {
		Local local = new Local(new Remote(), "Hello");

		local.sendMessage();
	}

	public void run() {
		remote.executeMessage(message, this);

	}
}

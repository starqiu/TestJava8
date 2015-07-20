/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Remote.java
 * 2015年7月17日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package callback;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月17日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
/** 
 * 处理消息的远程类 
 * 
 */  
public class Remote {  
  
    /** 
     * 处理消息 
     * @param msg   接收的消息 
     * @param callBack  回调函数处理类 
     */  
    public void executeMessage(String msg,CallBack callBack)  
    {  
        /**模拟远程类正在处理其他事情，可能需要花费许多时间**/  
          try {
        	 System.out.println("dealing");
			Thread.sleep(100000);
		} catch (InterruptedException e) {
		}
        /**处理完其他事情，现在来处理消息**/  
        System.out.println(msg);  
        System.out.println("I hava executed the message by Local");  
        /**执行回调**/  
        callBack.execute(new String[]{"Nice to meet you~!"});  
    }  
      
}  


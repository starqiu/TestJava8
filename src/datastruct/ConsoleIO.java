/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * ConsoleIO.java
 * 2015年7月31日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

import java.util.Scanner;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月31日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class ConsoleIO {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.printf("%d 的平方为%d，立方为%d\n", x, x*x,x*x*x);
		x = scanner.nextInt();
		System.out.printf("%d 的平方为%d，立方为%d\n", x, x*x,x*x*x);
	}
}


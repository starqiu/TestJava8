/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * MatrixInCycle.java
 * 2015年8月4日
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
 *2015年8月4日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class MatrixInCycle {

	public static int[][]  genCycleMatrix(int rows, int columns) throws Exception{
		int[][] a = new int[rows][columns];
		
		int startNumber = 1;
		for (int start = 0; start * 2 < rows && start *2 < columns ;start++) {
			startNumber = genCycleMatrix(a, rows, columns, start, startNumber);
		}
		
		return a;
		
	}
	
	public static int genCycleMatrix(int[][] a, int rows, int columns , int start ,int startNumber){
		int endX = rows -1 - start;
		int endY = columns -1 - start;
		
		//从左到右
		for (int i = start; i <= endX; i++) {
			a[start][i] = startNumber++;
		}
		//从上到下
		if (start < endY) {
			for (int i = start+1; i <= endY; i++) {
				a[i][endY] = startNumber++;
			}
		}
		//从右到左
		if (start < endY && start < endX) {
			for (int i = endX-1; i >=  start; i--) {
				a[endY][i] = startNumber++;
			}
		}
		//从下到上
		if (start < endY-1 && start < endX) {
			for (int i = endY-1; i >  start; i--) {
				a[i][start] = startNumber++;
			}
		}
		
		return startNumber;
	}
	
	public static void print2DimMatrix(int[][] a ,int rows, int columns) throws Exception{
		if (a ==null ) {
			throw new Exception("array can not be null!");
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.printf("%8d",a[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[][] a= genCycleMatrix(6, 6);
		print2DimMatrix(a,6, 6);
	}
}


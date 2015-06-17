package week7;

import java.util.*;
class TestStringTokenizer 
{
	public static void main(String[] args) 
	{
		StringTokenizer st = new StringTokenizer("this is a test", " ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		st = new StringTokenizer("253,197,546", ",");
		double sum = 0;
		while (st.hasMoreTokens()) {
			sum += Double.parseDouble(st.nextToken());
		}
		System.out.println( sum );
	}
}

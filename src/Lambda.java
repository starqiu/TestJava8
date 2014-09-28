import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.IntToDoubleFunction;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Lambda.java
 * 2014��9��28��
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
 *2014��9��28��        ����         starqiu@mail.ustc.edu.cn	    �½���<br /></p>
 *
 */
public class Lambda {
	
	public static void recursiveLambda(){
		IntToDoubleFunction[] foo = {null };
		foo[0] = x -> { return  ( x == 0)?1:x* foo[0].applyAsDouble(x-1);};
		System.out.println(foo[0].applyAsDouble(5));//120.0
	}
	
	
	public static void captureVariable(){
		/*
		 *  Lambda���ʽ��ǿ���㽫��������Ϊfinal�� ֻҪ������Ϊ��final ����һ�����ɣ�Ҳ���ǵȼ�final.
		 *	���������s��������Ϊfinal��ʵ�ʼ���finalҲ����������
		 */
		String s = "smallnest";
		Runnable r = () -> System.out.println("hello " + s);
		r.run(); 
		/*
		 * ע��final�����Ǳ��������ٱ���ֵ�� �������ֶε�ֵ�ǿ��Ըı�ġ�
		 * �������ǿ��Ը���s��str�ֶε�ֵ��
		 * */
		Sample sam = new Sample();
		sam.setStr("smallnest");
		Runnable r2 = () -> System.out.println("hello " + sam.getStr());
		sam.setStr("colobu");
		r2.run();
		
	}
	
	public static void serilizable(){
		try {
			Runnable r = (Runnable & Serializable)() -> System.out.println("hello serialization");
			FileOutputStream fos = new FileOutputStream("Runnable.lambda");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(r);
			FileInputStream fis = new FileInputStream("Runnable.lambda");
			ObjectInputStream is = new ObjectInputStream(fis);
			r = (Runnable) is.readObject();
			r.run();
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void methodReference(){
		BiFunction<Long,Long,Integer> bf = Long::compare;
		Long a = 10L;
		Long b = 11L;
		System.out.println(bf.apply(a, b));
		
		String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(stringArray));
	}

	interface B {	 
		default void say() {
			System.out.println("B says");
		}
	}
	class C {
		
		public void say() {
			System.out.println("C says");
		}
	}
	class D extends C implements  B{
		
	}
	
	/**
	 * ԭ��
		�����ϣ�����Ը�����������ԭ���ж϶�̳е�ʵ�ֹ���
		
		�������ڽӿڡ� ���һ������̳еĸ���ͽӿ�����ͬ�ķ���ʵ�֡� ��ô�ӿ��еĶ���ᱻ���ԡ� ����������ӡ�
		�������еķ��������ڸ������еķ����� ���һ�����ӡ�
		������������������㣬 ��ڶ������ӣ��������ʾ����/ʵ���䷽��������������abstract��
	 */
	public  void multiExtends(){
		D d = new D();
		d.say();//"C says"
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//recursiveLambda();
		//captureVariable();
//		serilizable();
//		methodReference();
//		new Lambda().multiExtends();
	}

}


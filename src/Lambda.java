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
import java.util.stream.Stream;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Lambda.java
 * 2014年9月28日
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
 *2014年9月28日        邱星         starqiu@mail.ustc.edu.cn	    新建类<br /></p>
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
		 *  Lambda表达式不强迫你将变量声明为final， 只要它的行为和final 变量一样即可，也就是等价final.
		 *	下面的例子s不必声明为final，实际加上final也不会编译出错。
		 */
		String s = "smallnest";
		Runnable r = () -> System.out.println("hello " + s);
		r.run(); 
		/*
		 * 注意final仅仅是变量不能再被赋值， 而变量字段的值是可以改变的。
		 * 这里我们可以更改s的str字段的值。
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
	 * 原则：
		基本上，你可以根据以下三条原则判断多继承的实现规则。
		
		类优先于接口。 如果一个子类继承的父类和接口有相同的方法实现。 那么接口中的定义会被忽略。 如第三个例子。
		子类型中的方法优先于父类型中的方法。 如第一个例子。
		如果以上条件都不满足， 如第二个例子，则必须显示覆盖/实现其方法，或者声明成abstract。
	 */
	public  void multiExtends(){
		D d = new D();
		d.say();//"C says"
	}
	public static void test(){
		String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
		Stream.of(stringArray).mapToInt(String::length).forEach(x->System.out.printf("%s ",x));
		System.out.println();
		Stream.of(stringArray).mapToInt(String::length).sorted().forEach(x->System.out.printf("%s ",x));
		System.out.println();
		Stream.of(stringArray).mapToInt(String::length).sorted().limit(3).forEach(x->System.out.printf("%s ",x));
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
//		test();
		double f = 6f/7;
		System.out.println(f);
	}

}
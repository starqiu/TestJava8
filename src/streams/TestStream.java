package streams;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestStream.java
 * 2015å¹?6æœ?24æ—?
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * å®žçŽ°åŠŸèƒ½ï¼? 5 methods to create Stream
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015å¹?6æœ?24æ—?	 é‚±æ˜Ÿ            starqiu@mail.ustc.edu.cn	      æ–°å»ºç±?<br /></p>
 *
 */
public class TestStream {
	
	public static void main(String[] args) {
		String[] a1 = {"a","b","c"};
		String[] a2 = {"d","e","f"};
		String[] a3 = {"g","h","i"};
		
		Stream<String> stream1 = Stream.of(a1);
		Stream<String> stream2 = Stream.of(a2);
		Stream<String> stream3 = Stream.of(a3);
		
		//from Array
		System.out.println("======from Array=======");
//		Stream<String> stream = Stream.of(stream1,stream2,stream3).flatMap(x-> x);
//		
//		stream.forEach(System.out::println);
//		
//		Stream<String> stream4 = Stream.of(stream1,stream2,stream3).flatMap(x-> x);
//		int minValue = stream4.mapToInt(x -> x.charAt(0)).min().getAsInt(); 
//		System.out.println(minValue);
		
		Stream<String> stream5 = Stream.of(stream1,stream2,stream3).flatMap(x-> x);
//		String[] arr = stream5.toArray(lengh-> new String[lengh]); //ok
		String[] arr = stream5.toArray(String[]::new);
		System.out.println(Arrays.toString(arr));
		
		//from Collections
		System.out.println("====from Collections=======");
		List<String> list = Arrays.asList(a1);
		list.stream().forEach(x -> System.out.printf("%s ",x));
		System.out.println();
		//infinite
		System.out.println("=====infinite========");
		Stream.generate(() -> "test").limit(10).forEach(x -> System.out.printf("%s ",x));;
		System.out.println();
		Stream.iterate(0, n -> n+1).limit(5).forEach(x -> System.out.printf("%s ",x));
		System.out.println();
		
		//from APIs
		System.out.println("=====from APIs=======");
		String words = "hello world my name is star";
		Pattern.compile("\\W").splitAsStream(words).forEach(x -> System.out.printf(" |%s| ",x));
	}

}


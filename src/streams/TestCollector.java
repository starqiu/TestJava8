package streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestCollector.java
 * 2015年6月23日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年6月23日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestCollector {

	public static void main(String[] args) {
		List<People> friendList = Arrays.asList(new People("Jone", 20),
				new People("Sara", 21), new People("Jane", 21), new People(
						"Greg", 35));
	
		System.out.println("simple collect:");
		List<People> result =  friendList
				.stream()
				.sorted(Comparator.comparing(People::getAge))
				.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
		result.stream().forEach(System.out::println);
		System.out.println("===========================================");
		
		System.out.println("use function of Collectors: ");
		List<People> result1 =  friendList
				.stream()
				.sorted(Comparator.comparing(People::getAge))
				.collect(Collectors.toList());
		result1.stream().forEach(System.out::println);
		System.out.println("===========================================");
		
		System.out.println("use groupingBy:");
		Map<Integer, List<People>> result2 = friendList
			.stream()
			.collect(Collectors.groupingBy(People::getAge));
		System.out.println(result2);
		System.out.println("===========================================");
		
		System.out.println("use groupingBy and mapping:");
		Map<Integer, List<String>> result3 =friendList
				.stream()
				.collect(Collectors.groupingBy(People::getAge
						,Collectors.mapping(People::getName, Collectors.toList())));
		System.out.println(result3);
		System.out.println("===========================================");
		
		System.out.println("use groupingBy ,mapping and maxBy:");
		Map<Integer, Optional<People>> result4 =friendList
				.stream()
				.collect(Collectors.groupingBy(People::getAge
						,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(People::getName)))));
		System.out.println(result4);
		System.out.println("===========================================");
		
		System.out.println("another example which use groupingBy ,mapping and maxBy:");
		Map<Character, Optional<People>> result5 =friendList
				.stream()
				.collect(Collectors.groupingBy(p -> p.getName().charAt(0)
						,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(People::getAge)))));
		System.out.println(result5);
		
		
		
	}
}


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestComparator.java
 * 2015年6月23日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能：
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015年6月23日 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 *
 */
public class TestComparator {

	public static void main(String[] args) {
		List<People> friendList = Arrays.asList(new People("Jone", 20),
				new People("Sara", 21), new People("Jane", 21), new People(
						"Greg", 35));

		List<People> result;
		result = friendList
				.stream()
				.sorted(People::ageDifference)
				.collect(Collectors.toList());
		printPeoples("1:", result);
		// friendList.stream().sorted(People::ageDifference).forEach(System.out::println);

		result = friendList
				.stream()
				.sorted(Comparator.comparing(People::getAge).thenComparing(
						People::getName))
				.collect(Collectors.toList());

		printPeoples("2:", result);

		friendList
				.stream()
				.min(Comparator.comparing(People::getAge))
				.ifPresent(p -> System.out.println(String.format("youngest: %s", p)));
		
		friendList
				.stream()
				.max(Comparator.comparing(People::getAge))
				.ifPresent(p -> System.out.println(String.format("eldest: %s", p)));
		
		friendList
				.stream()
				.min(Comparator.comparing(People::getAge).reversed())
				.ifPresent(p -> System.out.println(String.format("eldest: %s", p)));
		
	}

	public static void printPeoples(String promot, final List<People> peoples) {
		System.out.println(promot);
		peoples.forEach(System.out::println);
	}
}

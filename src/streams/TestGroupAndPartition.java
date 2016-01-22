/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestGroupAndPartition.java
 * 2016��1��22��
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class TestGroupAndPartition {
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Alice", "London", 200));
		employees.add(new Employee("Bob", "London", 150));
		employees.add(new Employee("Charles", "New York", 160));
		employees.add(new Employee("Dorothy", "Hong Kong", 200));
		
		//分组
		Map<String, List<Employee>> employeeByCity = 
				employees.stream().collect(
						groupingBy(Employee::getCity));
		
		System.out.println(employeeByCity);
		
		Map<String, String> employeeByCityToStr = 
				employees.stream().collect(
						groupingBy(Employee::getCity,
								mapping(Employee::getName, joining(" | "))));
		
		System.out.println(employeeByCityToStr);
		
		Map<String, Long> numEmployeeByCity = 
				employees.stream().collect(
						groupingBy(Employee::getCity,counting()));
		
		System.out.println(numEmployeeByCity);
		
		Map<String, Double> avgNumSaleEmployeeByCity = 
				employees.stream().collect(
						groupingBy(Employee::getCity,
								averagingInt(Employee::getNumSales)));
		
		System.out.println(avgNumSaleEmployeeByCity);
		
		//分区
		Map<Boolean, List<Employee>> partitioned  = 
				employees.stream().collect(partitioningBy(e -> e.getNumSales() >150));
		System.out.println(partitioned);
		
		Map<Boolean, Map<String, Long>> result  = 
				employees.stream().collect(
						partitioningBy(e -> e.getNumSales() >150,
								groupingBy(Employee::getCity,counting())));
		System.out.println(result);
		System.out.println(result.get(true));
	}

}


package week8;

import java.util.*;

import com.sun.accessibility.internal.resources.accessibility;
class UseParallelStream 
{
	public static void main(String[] args) 
	{
		List<Integer> a = Arrays.asList(1,2,5,7,3);
		System.out.println(
		a.parallelStream()
			.mapToInt(i->(int)i)
			.filter( i -> i>2 )
			.map( i -> i*i )
			.sorted()
			.distinct()
			.limit(10)
			.max()
		);
		
		System.out.println(
				Arrays.toString(
						a.parallelStream()
						.mapToInt(i -> (int) i)
						.sorted()
						// .filter( i -> i>2 )
						// .map( i -> i*i )
						// .distinct()
						// .limit(10)
						// .forEach(e -> System.out.println(e));
						.toArray()));
		ArrayList list = 
			a.parallelStream()
			.mapToInt(i -> (int) i)
//			.filter( i -> i>2 )
			.map( i -> i*i )
			.distinct()
			.sorted()
			.limit(10)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//			.forEach(e -> System.out.println(e));
		System.out.println(list.toString());
	}
}


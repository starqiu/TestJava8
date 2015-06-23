import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestOptional.java
 * 2015年6月19日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： Optional
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年6月19日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestOptional {
	
	public static void main(String[] args) {
		String[] arr = {"hello","world","gfsd","hgw","qetu","hcslgp"};
		List<String> list = Arrays.asList(arr);

		pickName(list, "h");
		pickName(list, "z");
	}
	
	static void pickName(List<String> list , String letter){
		Optional<String> result = list.stream()
				.filter(name->name.startsWith(letter))
				.findFirst();
		
		System.out.printf("A volcabulary start with %s:%s\n", letter,result.orElse("Not Found"));
		result.ifPresent(name -> System.out.println("Hello "+name));
	}

}


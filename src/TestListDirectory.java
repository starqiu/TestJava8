import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestListDirectory.java
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
public class TestListDirectory {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("output all files:");
		Files.list(Paths.get("./src"))
				.forEach(System.out::println);;
		System.out.println("==============================================");
		
		System.out.println("output java files:");
		Files.list(Paths.get("./src"))
				.filter(p -> p.toString().endsWith(".java"))
				.forEach(System.out::println);;
		System.out.println("==============================================");
		
		System.out.println("output hidden files:");
		Arrays.asList(new File(".").listFiles(File::isHidden))
					.stream()
					.forEach(System.out::println);
		System.out.println("==============================================");
		
		System.out.println("output ava files in specific directory and its sub-directory :");
		Stream.of(new File("./src").listFiles())
						.flatMap(file -> file.isFile()?Stream.of(file):Stream.of(file.listFiles()))
						.forEach(System.out::println);
		System.out.println("==============================================");
		
		System.out.println("watch file modified :");
		Path p = Paths.get("./src");
		WatchService ws = p.getFileSystem().newWatchService();
		
		p.register(ws, StandardWatchEventKinds.ENTRY_MODIFY);
		
		WatchKey wk = ws.poll(1, TimeUnit.MINUTES);
		
		if (wk != null) {
			wk.pollEvents().stream().forEach(e -> System.out.println(e.context()));
		}
		
		System.out.println("==============================================");
		
		
		
		 
	}
}


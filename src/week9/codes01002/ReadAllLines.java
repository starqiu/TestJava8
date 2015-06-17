package week9.codes01002;

import java.nio.file.*;
import java.nio.charset.*;
import java.util.List;

class ReadAllLines
{
	public static void main(String[] args) throws java.io.IOException
	{
		String filePath = "D:\\workspace\\TestJava8\\src\\week9\\codes01002\\ReadAllLines.java";

		List<String> lines = Files.readAllLines(
			Paths.get(filePath),  
			Charset.forName("utf8") //or Charset.defaultCharset()
		);
		for(String s : lines ) System.out.println(s);
	}
}

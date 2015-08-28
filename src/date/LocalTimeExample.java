/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * LocalTimeExample.java
 * 2015年8月28日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package date;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年8月28日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
import java.time.LocalTime;
import java.time.ZoneId;
 
/**
 * LocalTime Examples
 * @author pankaj
 *
 */
public class LocalTimeExample {
 
    public static void main(String[] args) {
 
        //Current Time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);
 
        //Creating LocalTime by providing input arguments
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
 
        //Try creating time by providing invalid inputs
        //LocalTime invalidTime = LocalTime.of(25,20);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid value for HourOfDay (valid values 0 - 23): 25
 
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST="+timeKolkata);
 
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
 
        //Getting date from the base date i.e 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);
 
    }
 
}

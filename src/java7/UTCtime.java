package java7;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by starqiu on 16-6-12.
 */
public class UTCtime {
    public static void main(String[] argv) throws Exception{
        //new Date
        System.out.println("=============Date================");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1989-09-05");
        long longDate = date.getTime();
        System.out.println(longDate);//620924400000

        Date parsedDate = new Date(longDate);
        System.out.println(parsedDate);//Tue Sep 05 00:00:00 CDT 1989
        System.out.println(parsedDate.getTime());//620924400000
        System.out.println(sdf.format(parsedDate));//1989-09-05

        System.out.println("=============Calendar================");

        //Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //calendar.set(1989,8,5,0,0,0);
        System.out.println(calendar.getTime());//Tue Sep 05 00:00:00 CDT 1989
        calendar.set(Calendar.MILLISECOND, 0);
        long longCalendar = calendar.getTimeInMillis();
        System.out.println(longCalendar);//620924400000
        System.out.println(calendar.get(Calendar.MILLISECOND));//0

        Calendar parsedCalendar = Calendar.getInstance();
        parsedCalendar.setTimeInMillis(longCalendar);
        System.out.println(parsedCalendar.getTimeInMillis());//620924400000
        System.out.println(sdf.format(parsedCalendar.getTime()));//1989-09-05

        System.out.println("==============joda===============");
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTime = dtf.parseDateTime("1989-09-05");
        System.out.println(dateTime);//1989-09-05T00:00:00.000+09:00
        long longDateTime = dateTime.getMillis();
        System.out.println(longDateTime);//620924400000
        DateTime dateTime1 = new DateTime(longDateTime);
        System.out.println(dateTime1);//1989-09-05T00:00:00.000+09:00
        System.out.println(dateTime1.getMillis());//620924400000
    }
}

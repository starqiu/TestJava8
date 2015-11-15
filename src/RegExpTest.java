import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpTest {

    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        System.out.println(str.matches(".*\\(.*$"));
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        while(m.find()) {
            System.out.println(m.group());
        }
        
        System.out.println(Arrays.toString(str.split("[\\(\\)]+")));
    }
}
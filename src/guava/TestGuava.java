package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.math.IntMath;

import java.util.List;

/**
 * Created by starqiu on 16-8-16.
 */
public class TestGuava {
    public static void main(String[] args) {
        testJoiner();
        testSplitter();
        testBinomial();
    }

    public static void testJoiner(){
//        Joiner joiner = Joiner.on("; ").skipNulls();
        Joiner joiner = Joiner.on("; ").useForNull("null");
        String res = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(res);
    }

    public static void testSplitter(){
        Splitter splitter = Splitter.on(',')
                .trimResults();
//                .omitEmptyStrings();
        List<String> res = splitter.splitToList("foo,bar,,   qux");
        System.out.println(res);
    }
    public static void testBinomial(){
        System.out.println(IntMath.binomial(5,2));
    }
}

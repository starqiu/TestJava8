/**
 * Created by starqiu on 16-8-25.
 */
public class T  implements Cloneable{
    public static int k = -1;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    public int j = print("j");
    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public T(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n; ++ i;
        System.out.println(t1+" "+t2);
    }

    public static int print(String str){
        System.out.println((++k) +":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++ i;
    }

    public static void main(String[] args){
        T t = new T("init");

        for (int j = 0; j < Integer.MAX_VALUE; j++) {
            System.out.println("V");
        }
    }
}

class T1  implements Cloneable{
    public static int k;
    public static T1 t1;
    public static T1 t2;
    public static int i;
    public static int n;

    public int j ;
    {
        j = print("j");
        print("构造块");
    }

    static {
        k = -1;
        t1 = new T1("t1");
        t2 = new T1("t2");
        i = print("i");
        n = 99;
        print("静态块");
    }

    public T1(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n; ++ i;
//        System.out.println(t1+" "+t2);
    }

    public static int print(String str){
        System.out.println((++k) +":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++ i;
    }

    public static void main(String[] args){
        T1 t = new T1("init");
    }
}
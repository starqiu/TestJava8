package week6;

public class TestTryFinally {
    public static String output = "";

    public static int foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        } catch(Exception e) {
            output += "2";
            return ret();
        } finally {
            output += "3";
        }
        output += "4";
        return 6;
    }

    public static int ret(){
    	output += "5";
    	return 1;
    }
    
    public static void main(String args[]) {
        //foo(0);
        //System.out.print(output + " ");
        foo(1);
        System.out.println(output);
    }
}
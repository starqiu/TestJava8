package week5;

public class TestInnerThis
{    
	public static void main(String args[]){
		A1 a = new A1();
		A1.B b = a.new B();
	    b.mb(333); 
    }
}

class A1
{
	private int s = 111;

	public class B {
	    private int s = 222;
    	public void mb(int s) {
	        System.out.println(s); // �ֲ�����s
	        System.out.println(this.s); // �ڲ�����������s
	        System.out.println(A1.this.s); //  ������������s
	    }
    }
}

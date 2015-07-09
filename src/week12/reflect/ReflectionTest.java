package week12.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ReflectionTest
{
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args)throws Exception
    {
        
       // 1. �õ��ö�������Ӧ��Class����
       Class<DemoTest2> clazz = DemoTest2.class;
        
       //2. ͨ����Class����õ�����Ĺ��췽������Ӧ��Constructor����
        Constructor cons = clazz.getConstructor(new Class[]{String.class, String.class});
                
        //3. ͨ����Constructor�����newInstance�����õ������һ��ʵ��������
        DemoTest2 obj = (DemoTest2)cons.newInstance(new Object[]{"abc","xyz"});
       
        //4. ͨ����Class����õ��÷�������Ӧ��Method����
        Method method = clazz.getDeclaredMethod("output",new Class[]{String.class});
        
        //5. ͨ����Method�����invoke�������е���
        method.invoke(obj,new Object[]{"zhangsan"});
        
        //����Ҳ����
		Field field = clazz.getDeclaredField("x");
		field.setAccessible(true);//�������Է���private�����Ի򷽷�
		field.set(obj, 6);

		obj.print();
		
    }
}

class DemoTest2
{
	private int x = 5;
	public DemoTest2(String s1, String s2)
    {
        System.out.println(s1);
        System.out.println(s2);
    }
    
    void output(String str)
    {
        System.out.println("hello: " + str);
    }
    
    public void print(){
    	System.out.println(x);
    }

}
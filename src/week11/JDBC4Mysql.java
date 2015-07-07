package week11;

import java.sql. * ;
//��Ȼ������Ҫ��װ��JDK(һ����JDK1.5.X)��Ȼ��װMySQL����Щ���Ƚϼ򵥣�������̾Ͳ�˵�ˡ�
//���ú�����������������JDBC����mysql-connector-java-5.1.30.zip��
//Ȼ�����ѹ������һĿ¼�����ǽ�ѹ��D�̣�Ȼ����Ŀ¼�µ�mysql-connector-java-5.1.30-bin.jar�ӵ�classpath�
//�������£����ҵĵ��ԡ�-> �����ԡ� ->           ���߼��� ->           ����������������ϵͳ��������༭classpath����D:\mysql-connector-java-5.0.5\mysql-connector-java-5.0.5-bin.jar�ӵ�����ڼ�����ַ���ǰҪ�ӡ�;��������ǰһ��classpath���ֿ���Ȼ��ȷ����

//ֱ�ӽ�mysql-connector-java-5.1.18-bin.jar���뵽���̵�Build Path���ɡ����裺ѡ�й�������������Ҽ�����ѡ��Properties��������Java Build Path��������Libraries��������Add External JARs�����򿪵ĶԻ�����ѡ��mysql-connector-java-5.1.18-bin.jar���Ϳ�������ִ���ˡ�
//Web��Ŀ����ʱ������ǰ�JDBC���������硰mysql-connector-java-5.1.30-bin.jar���ŵ�WebRoot/Web-INF/libĿ¼�£�

public class JDBC4Mysql {
	public static void main(String[] args) {
		// ����������          
		String driver = "com.mysql.jdbc.Driver";

		// URLָ��Ҫ���ʵ����ݿ���           
		String url = "jdbc:mysql://127.0.0.1:3306/mysql";

		// MySQL����ʱ���û���           
		String user = "root";

		// MySQL����ʱ������           
		String password = "xing123";
		try {
			// ������������           
			Class.forName(driver);

			// �������ݿ�           
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) System.out.println("Succeeded connecting to the Database!");

			// statement����ִ��SQL���            
			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���            
			String sql = "select * from db limit 10 ";

			// �����            
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				String name = rs.getString("Host");
				System.out.println(rs.getString("DB") + "\t" + name);
			}
			rs.close();
			conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
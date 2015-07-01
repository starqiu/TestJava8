package week11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.*;

import javax.swing.table.*;

class JDBCJTable extends JFrame
{
	AbstractTableModel tm;		//����һ����AbstractTableModel����
	JTable table;				//����һ����JTable����
	JScrollPane scrollpane;		//����һ������������
	String titles[];			//��ά������
	Class colClasses[];			//��ά���е�����
	Vector<Vector<Object>> records;				//����һ����������

	public void initTablModel(){
		records = new Vector<>();	//ʵ��������
		tm = new AbstractTableModel(){
			public int getColumnCount(){
				return titles.length;	//ȡ�ñ������
			}
			public int getRowCount(){
				return records.size();		//ȡ�ñ������
			}
			public Object getValueAt(int row,int column){
				if(!records.isEmpty())		//ȡ�õ�Ԫ���е�����ֵ
					return ((Vector)records.elementAt(row)).elementAt(column);
				else
					return null;
			}

			public String getColumnName(int column){
				return titles[column];	//���ñ������
			}

			public Class getColumnClass(int column){
				//return getValueAt(0,column).getClass();	//ȡ��������������
				return colClasses[column];
			}

			public void setValueAt(Object value,int row,int column){
					//����ģ�Ͳ��ɱ༭���÷�������Ϊ��
			}
			public boolean isCellEditable(int row,int column){
				return false;//���õ�Ԫ�񲻿ɱ༭��Ϊȱʡʵ��
			}
		};
	}

	public void showData() throws SQLException, ClassNotFoundException{

		// ������������
		Class.forName("org.sqlite.JDBC");

		//�õ������ݿ������
		String connString = "jdbc:sqlite:d:/test3.db";
		Connection connection = DriverManager.getConnection(connString);

		//ִ�в�ѯ�� 
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from people");
		ResultSetMetaData meta = rs.getMetaData();	//�õ�Ԫ����

		//��ʾ��� 
		int colCnt = meta.getColumnCount();
		System.out.println( colCnt );
		titles = new String[ colCnt ];
		colClasses = new Class[ colCnt ];
		for( int i=0; i<colCnt; i++){
			titles[i] = meta.getColumnName(i+1);	//�õ�����,ע���±��Ǵ�1��ʼ��
			String className =  meta.getColumnClassName(i+1);
			Class clz = String.class;//�õ���������
			if(className!=null) try
			{
				clz = Class.forName(className);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			colClasses[i] =	clz; 
		}

		records.removeAllElements();//��ʼ����������
		while(rs.next()){
			Vector<Object> rec_vector=new Vector<>();
			//�ӽ������ȡ���ݷ�������rec_vector��
			for ( int i=0; i<titles.length; i++ ){
				Object obj = rs.getObject(i+1);
				System.out.print(obj+";");
				rec_vector.addElement(obj==null?null:obj.toString());
			}
			records.addElement(rec_vector);
			System.out.println();
		}

		//���Ʊ�� 
		table=new JTable();	//�����Լ�������ģ��
		table.setToolTipText("��ʾȫ����ѯ���");	//���ð�����ʾ
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//���ñ������ߴ�ģʽ
		table.setCellSelectionEnabled(false);	//���õ�Ԫ��ѡ��ʽ
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		
		
		scrollpane=new JScrollPane(table);		//�������Ϲ�����
		getContentPane().add( scrollpane );

		table.setModel(tm);
		tm.fireTableStructureChanged();//���±��
		
		//ע���趨���ݣ�Ҳ���������µĹ��췽��
		//JTable(TableModel dm)
		//JTable(Object[][] rowData, Object[] columnNames) )
		//JTable(Vector rowData, Vector columnNames) 		
	}

	public static void main( String [] args ){
		SwingUtilities.invokeLater(()->{
			JDBCJTable f = new JDBCJTable();
			f.initTablModel();
			try{
				f.showData();
			}catch( Exception e){ e.printStackTrace(); }
			f.setSize( 400,300);
			f.setTitle( "Show Database table in JTable" );
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		});
	}

}




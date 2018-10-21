import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class CourseFrame extends JFrame implements ActionListener
{
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2,b3;
	JComboBox c1,c2,c3;
	JTextField t1,t2,t3,t4,t5;
	JTextArea ta ;
	int id;
	int age,per;
	String name,address,gender,ug,pg;
	void createControls()throws Exception
	{
		jf=new JFrame("Student's Registration Form");
		jf.setExtendedState(jf.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);		
		l1=new JLabel("STUDENT REGISTRATION");
		l2=new JLabel("NAME");
		l3=new JLabel("GENDER");	
		l6=new JLabel("UG COURSE");
		l7=new JLabel("UG PERCENTAGE");
		l4=new JLabel("AGE");
		l8=new JLabel("PG COURSE");
		l5=new JLabel("ADDRESS");
		b1=new JButton("Register");
		b2=new JButton("Display");
		b3=new JButton("Clear");
		c1=new JComboBox();
		c2=new JComboBox();
		c3=new JComboBox();
		t4=new JTextField(20);
		ta=new JTextArea();
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);	
		t5=new JTextField(20);
		l9=new JLabel("Id");	
		l1.setBounds(400,40,200,20);jf.add(l1);
		l9.setBounds(100,90,200,20);jf.add(l9);
		t5.setBounds(200,90,200,20);jf.add(t5);
		l2.setBounds(100,140,200,20);jf.add(l2);
		t1.setBounds(200,140,200,20);jf.add(t1);
		l3.setBounds(100,190,200,20);jf.add(l3);
		c1.setBounds(200,190,200,20);jf.add(c1);
		l4.setBounds(100,240,200,20);jf.add(l4);
		t2.setBounds(200,240,200,20);jf.add(t2);
		l5.setBounds(100,290,200,20);jf.add(l5);
		t3.setBounds(200,290,200,20);jf.add(t3);
		l6.setBounds(100,340,200,20);jf.add(l6);
		c2.setBounds(200,340,200,20);jf.add(c2);
		l7.setBounds(100,390,200,20);jf.add(l7);
		t4.setBounds(200,390,200,20);jf.add(t4);
		l8.setBounds(100,440,200,20);jf.add(l8);
		c3.setBounds(200,440,200,20);jf.add(c3);
		b1.setBounds(100,500,100,40);jf.add(b1);
		b2.setBounds(200,500,100,40);jf.add(b2);
		b3.setBounds(300,500,100,40);jf.add(b3);
		ta.setBounds(450,100,900,900);jf.add(ta);
	}

	void addControls()throws Exception
	{
		jf.setLayout(null);
		b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
		c1.addItem("-");
		c1.addItem("Female");
		c1.addItem("Male");
		c2.addItem("-");
		c2.addItem("BCA");
		c2.addItem("BSC(cs)");
		c2.addItem("BE-EEE");
		c2.addItem("BE-ECE");
		c2.addItem("BE-CSE");
		c3.addItem("-");
		c3.addItem("MCA");
		c3.addItem("ME-EEE");
		c3.addItem("ME-ECE");
		c3.addItem("ME-CSE");
		jf.add(l1);
		jf.add(l9);
		jf.add(t5);
		jf.add(l2);
		jf.add(t1);
		jf.add(l3);
		jf.add(l4);
		jf.add(l5);
		jf.add(l6);
		jf.add(l7);
		jf.add(l8);
		jf.add(l9);
		jf.show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			id=Integer.parseInt(t5.getText());
			name=t1.getText();
			gender=String.valueOf(c1.getSelectedItem());
			age=Integer.parseInt(t2.getText());
			address=t3.getText();
			ug=String.valueOf(c2.getSelectedItem());
			per=Integer.parseInt(t4.getText());
			pg=String.valueOf(c3.getSelectedItem());
			if(per>75)
			{
			String query="insert into Students (id,name,gender,age,address,ug,per,pg) values(?,?,?,?,?,?,?,?)";
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,gender);
			ps.setInt(4,age);	
			ps.setString(5,address);	
			ps.setString(6,ug);
			ps.setInt(7,per);
			ps.setString(8,pg);
			JOptionPane.showMessageDialog(jf,"You are Registered");
			//id++;
			ps.executeUpdate();
			con.close();
			}
			else
				JOptionPane.showMessageDialog(jf,"You are not Registered");
			
			}catch(Exception e){System.out.println(e);}
		}
		if(ae.getSource()==b2)
		{
			try{String inp=JOptionPane.showInputDialog(jf,"Enter your id","Id needed(title)",JOptionPane.WARNING_MESSAGE);
			int input=Integer.parseInt(inp);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from students where id="+input);
			ta.append("Student Details \n");
			while(rs.next())
			{
				ta.append("ID: ");
				String s1=Integer.toString(rs.getInt(1));ta.append(s1);
				ta.append("\nNAME: ");
				String s2=rs.getString(2);ta.append(s2);	
				ta.append("\nGENDER: ");
				String s3=rs.getString(3);ta.append(s3);
				ta.append("\nAGE: ");
				String s4=Integer.toString(rs.getInt(4));ta.append(s4);
				ta.append("\nUG: ");
				String s6=rs.getString(7);ta.append(s6);
				ta.append("\nPG: ");
				String s5=rs.getString(8);ta.append(s5);
					
			}
			con.close();
			}catch(Exception e){}
		}
		if(ae.getSource()==b3)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			ta.setText("");
			c1.setSelectedItem("-");
			c2.setSelectedItem("-");
			c3.setSelectedItem("-");
		}
		
	}
	public static void main(String args[])throws Exception
	{
		CourseFrame cf=new CourseFrame();
		cf.createControls();
		cf.addControls();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e){System.out.println(e.getMessage());}
			
	}
}
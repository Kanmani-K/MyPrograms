import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class jdbcf extends JFrame implements ActionListener
{
JFrame jf1;
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JButton b1,b2,b3,b4,b5,b6;
JTextArea ta;
int id,exp;
int incentive,bp,salary;

jdbcf()
{
setVisible(true);
setSize(700, 700);
 setLayout(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

l1=new JLabel("ID");
l2=new JLabel("Name");
l3=new JLabel("Basic Salary");
l4=new JLabel("experience");


tf1=new JTextField();
tf2=new JTextField();
tf3=new JTextField();
tf4=new JTextField();
ta=new JTextArea();

b1=new JButton("Insert ...");
//b2=new JButton("Salary Calculate");
b3=new JButton("View entry");
b4=new JButton("Clear");


b1.addActionListener(this);
//b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);




l1.setBounds(80,70,200,40);
l2.setBounds(80,130,200,40);
l3.setBounds(80,190,200,40);
l4.setBounds(80,250,200,40);




tf1.setBounds(300,70,200,40);
tf2.setBounds(300,130,200,40);
tf3.setBounds(300,190,200,40);
tf4.setBounds(300,250,200,40);


ta.setBounds(600,100,500,200);
add(ta);

b1.setBounds(50,450,100,30);
//b2.setBounds(160,450,100,30);
b3.setBounds(270,450,100,30);
b4.setBounds(380,450,200,30);



add(l1);add(l2);add(l3);add(l4);

add(tf1);add(tf2);add(tf3);add(tf4);

add(b1);add(b3);add(b4);
ta.setEditable(false);
}



public void actionPerformed(ActionEvent ae)
{


if(ae.getSource()==b1)
{
String s1=tf1.getText();
int n1=Integer.parseInt(s1);
String s2=tf2.getText();
String s3=tf3.getText();
int n2=Integer.parseInt(s3);
String s4=tf4.getText();
int n3=Integer.parseInt(s4);
try
{
//Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
int i;
bp=Integer.parseInt(tf3.getText());
exp=Integer.parseInt(tf4.getText());
		if (exp==1)
	            		    incentive = 1000+bp;
   	                else if (exp ==2)
            	 	                incentive = 2000+ bp;		
		else if (exp==3)
			incentive=3000 + bp;
		else if(exp==4)
			incentive=4000 + bp;
		else if(exp==5)
			incentive=5000 + bp;
		else 
			incentive=7000 + bp;
		int da=bp*15/100;
		int hra=bp*10/100;
		int gross_sal=bp+da+hra;
		salary=incentive+gross_sal;

PreparedStatement ps=con.prepareStatement("insert into jdbcf values(?,?,?,?,?)");
ps.setInt(1,n1);
ps.setString(2,s2);
ps.setInt(3,n2);
ps.setInt(4,n3);
ps.setInt(5,salary);
ps.executeUpdate();
JOptionPane.showMessageDialog(b1,"details are Inserted Successfully");
}catch(Exception e)
{
System.out.println("\n Exception "+e);
}
}

/*if(ae.getSource() ==b2)
{
try
{

int s1=Integer.parseInt(tf1.getText());
Double s3=Double.parseDouble(tf6.getText());
//Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
int i;
String s=tf1.getText();
i=Integer.parseInt(s);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select exp,salary from employee where id="+i);
exp=rs.getInt(4);
bp=rs.getInt(3);
		if (exp==1)
	            		    incentive = 1000+bp;
   	                else if (exp ==2)
            	 	                incentive = 2000+ bp;		
		else if (exp==3)
			incentive=3000 + bp;
		else if(exp==4)
			incentive=4000 + bp;
		else if(exp==5)
			incentive=5000 + bp;
		else 
			incentive=7000 + bp;
		int da=bp*15/100;
		int hra=bp*10/100;
		int gross_sal=bp+da+hra;
		salary=incentive+gross_sal;
		PreparedStatement ps1=con.prepareStatement("update employee set salary = ? where id= ?");
		
		ps1.setInt(2,salary);
		ps1.setInt(1,id);			
		ps1.executeUpdate();
		System.out.println("Employee details");
		JOptionPane.showMessageDialog(b2,"salary information Updated successfully...");
}
catch(Exception e)
{
System.out.println("\n Exception "+e);
}
}
*/

if(ae.getSource()==b3)
		{
			try{String inp=JOptionPane.showInputDialog(jf1,"Enter your id","Id needed(title)",JOptionPane.WARNING_MESSAGE);
			
			//String s=tf1.getText();		
			//i=Integer.parseInt(inp);
			int input=Integer.parseInt(inp);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from jdbcf where id="+input);
			ta.append("employee Details \n");
			while(rs.next())
			{
				ta.append("ID: ");
				String s1=Integer.toString(rs.getInt(1));ta.append(s1);
				ta.append("\nNAME: ");
				String s2=rs.getString(2);ta.append(s2);	
				ta.append("\nBASICPAY: ");
				String s3=Integer.toString(rs.getInt(3));ta.append(s3);
				ta.append("\nEXP: ");
				String s4=Integer.toString(rs.getInt(4));ta.append(s4);
				ta.append("\nSALARY: ");
				String s5=Integer.toString(rs.getInt(5));ta.append(s5);
					
			}
			con.close();
			}catch(Exception e){}
		}
		




if(ae.getSource() ==b4) //CLEAR
{
tf1.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
ta.setText("");
}
}

public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");

}
catch(Exception e){}

new jdbcf();
}
}




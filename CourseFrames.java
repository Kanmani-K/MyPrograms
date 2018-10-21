import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CourseFrame extends JFrame //implements ActionListener
{
	void createControls()
	{
		JFrame jf;
		Jlabel l1,l2,l3,l4,l5,l6,l7,l8;
		JButtons b1,b2,b3;
		JComboBox c1,c2,c3;
		JRadioButton r1,r2;
		JTextField t1,t2,t3;
		JTextArea ta1;
		JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
		jf=new JFrame("Student's REgistration Form");
		jf.setExtendedState(jf.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);		
		l1=new JLabel("STUDENT REGISTRATION");
		/*l1.setBounds();
		l2.setBounds();
		l3.setBounds();
		l4.setBounds();
		l5.setBounds();
		l6.setBounds();
		l7.setBounds();
		l8.setBounds();
		b1.setBounds();
		b2.setBounds();
		b3.setBounds();
		c1.setBounds();
		c2.setBounds();
		c3.setBounds();
		r1.setBounds();
		r2.setBounds();
		r3.setBounds();
		t1.setBounds();
		t2.setBounds();
		t3.setBounds();
		ta1.setBounds();*/
		l2=new JLabel("NAME");
		l3=new JLabel("GENDER");	
		l6=new JLabel("UG COURSE");
		l7=new JLabel("UG PERCENTAGE");
		l4=new JLabel("AGE");
		l8=new JLabel("PG COURSE");
		l5=new JLabel("ADDRESS");
		b1=new JButton("Register");
		b2=new JButton("Check Eligibility");
		b3=new JButton("Exit");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		c1=new JComboBox();
		c2=new JComboBox();
		c3=new JComboBox();
		ta=new JTextArea();
		r1=new JRadioButton("Female");
		r2=new JRadioButton("Male");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();		
	}
	void addControls()
	{
		jf.setLayout(new FlowLayout());
		//b1.addActionListener(this);
                //b2.addActionListener(this);
                //b3.addActionListener(this);

		p1.add(l1);
 		p2.add(l2);
		p2.add(t1);
		jf.add(p1);
		jf.add(p2);
		jf.show();
		
	}
	void showFrame()
	{

	}
	CourseFrame()
	{
		createControls();
		addControls();
		showFrame();
	}
	public static void main(String args[])
	{
		CourseFrame cf=new CourseFrame();
	}
}
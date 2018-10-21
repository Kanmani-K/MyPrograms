import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup.*;

class DiffLayouts extends JFrame implements ActionListener
{
	JFrame f1;
	JLabel luname,lpswd,header;
	JButton view1;
	JTextField t1;
	JRadioButton r1,r2;
	ButtonGroup bl;
	//JPanel p1,p2,p3,p4;
	DiffLayouts()
	{
		setLayout(new FlowLayout());
		setSize(1000,1000);
		r1=new JRadioButton("Student");
		r2=new JRadioButton("Admin");
		bl=new ButtonGroup();
		bl.add(r1);
		bl.add(r2);
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		header=new JLabel("COURSE REGISTRATION SYSTEM");
		add(header);
		add(r1);
		add(r2);
		r1.addActionListener(this);
		r2.addActionListener(this);
	}
	public static void main(String args[])
	{
		new DiffLayouts();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==r1)
			frame1();
		if(ae.getSource()==r2)
			frame2();	
		if(ae.getSource()==view1)
		{
			
		}	
}
	void frame1()
	{
		f1=new JFrame();
		//JPanel p1=new JPanel();
		f1.setSize(1000,1000);
		t1=new JTextField(10);
		view1=new JButton("Check");
		//back1=new JButton("Back");
		//System.out.println("Frame 1");
		BorderLayout bl=new BorderLayout();
		//setLayout(bl);
		JLabel l2=new JLabel("Check your details: ");
		l2.setFont(new Font("Serif",Font.BOLD,48));
		JLabel l1=new JLabel("Enter id");
		l1.setFont(
		f1.add(l2,bl.NORTH);
		f1.add(l1,bl.WEST);
		f1.add(t1,bl.EAST);
		f1.add(view1,bl.SOUTH);
		//p1.add(back1,bl.EAST);
		view1.addActionListener(this);
		f1.setVisible(true);
	}
	void frame2()
	{
		System.out.println("Frame 2");		
	}
	void frame3()
	{
		
	}
}
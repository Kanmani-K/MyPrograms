package course;
import java.io.*;

class UGRegister
{
	String name,address,reg_course,gender,age;
	int mark12,per12,mark10,per10;
	static int id;
	DataInputStream dis;
	
	boolean getDetailUG()
	{
		dis=DataInputStream(System.in);
		System.out.println("UG Registration: ");
		System.out.println("Enter name: ");
		name=dis.readLine();
		System.out.println("Enter Your age: ");
		age=Integer.parseInt(dis.readLine());
		System.out.println("Enter Your gender: ");
		gender=dis.readLine();
		System.out.println("Enter you address");
		address=dis.readLine();
		System.out.println("Enter your 10 th mark:");
		mark10=Integer.parseInt(dis.readLine());
		System.out.println("Enter your 10 th percentage:");
		per10=Integer.parseInt(dis.readLine());
		System.out.println("Enter your 12 th mark:");
		mark12=Integer.parseInt(dis.readLine());
		System.out.println("Enter your 12 th percentage:");
		per12=Integer.parseInt(dis.readLine());
		System.out.println("Enter your ug course");
		reg_course=dis.readLine();
		if((per10>75)&&(per12>75))
			return true;
		else
			return false;
	}		
	void display()
	{
		System.out.println("Student's Details: ");
		System.out.println("ID: "+id);
		System.out.println("Name: " +name);
		System.out.println("Gender: "+gender);
		System.out.println("Age: "+age);
		System.out.println("Course: "+reg_course);
	}
}
	
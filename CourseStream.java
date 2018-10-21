import java.io.Serializable;
import java.io.*;

class CourseStream implements Serializable
{
	transient String name,address,ug,reg_course;
	transient int id,per;
	transient boolean flag;
	DataInputStream dis;
	void  getDetail()throws Exception
	{
		dis=new DataInputStream(System.in);
		System.out.println("Enter id: ");
		id=Integer.parseInt(dis.readLine());
		System.out.println("Enter name: ");
		name=dis.readLine();
		System.out.println("Enter your address: ");
		address=dis.readLine();
		System.out.println("Enter Your UG Course: ");
		ug=dis.readLine();
		System.out.println("Enter Your UG Percentage: ");
		per=Integer.parseInt(dis.readLine());
		System.out.println("Enter your Course: ");
		reg_course=dis.readLine();
		if(per<75)
			flag=false;
		else
			flag=true;
	}
	/*void display(boolean flag)
	{
		if(flag)
		{
			System.out.println("Student Code: " +id);
			System.out.println("Name: " +name);
			System.out.println("Address: " +address);
			System.out.println("UnderGraduate Course: "+ug);
			System.out.println("UnderGraduate Percentage: "+per);
			System.out.println("Registered Course: "+reg_course);
		}
		else
		{
			System.out.println("Sorry! You are not eligible Your details are not included");			
		}
	}*/
}
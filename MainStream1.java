import java.io.*;
import java.io.Serializable;
class MainStream1
{
	public static void main(String _[])throws Exception
	{
		DataInputStream dis=null;
		FileInputStream fin=null;
		FileOutputStream fout=null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		//File file1=new File("Details.txt");
		try{
			dis=new DataInputStream(System.in);
			fout=new FileOutputStream("Details.txt");
			out=new ObjectOutputStream(fout);
			fin=new FileInputStream("Details.txt");
			in=new ObjectInputStream(fin);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}			
		CourseStream s[]=new CourseStream[5];
		CourseStream s1[]=new CourseStream[5];
		System.out.println("Enter no of Students: ");
		int n;
		n=Integer.parseInt(dis.readLine());
		for(int i=0;i<n;i++)
		{
		s[i]=new CourseStream();
		s1[i]=new CourseStream();
		s[i].getDetail();
		try{out.writeObject(s[i]);System.out.println("Success");
		}catch(Exception e){System.out.println(e.getMessage());}
		//System.out.println("hello");
		out.close();
		try{s1[i]=(CourseStream)in.readObject();}catch(Exception e){System.out.println(e.getMessage());}
		if(s1[i].flag)
		{
		System.out.println("Student Code: " +s1[i].id);
		System.out.println("Name: " +s1[i].name);
		System.out.println("Address: " +s1[i].address);
		System.out.println("UnderGraduate Course: "+s1[i].ug);
		System.out.println("UnderGraduate Percentage: "+s1[i].per);
		System.out.println("Registered Course: "+s1[i].reg_course);
		}
		else
		{
		System.out.println("Sorry! You are not eligible Your details are not included");			
		}
	}
}
 }
class CourseStream implements Serializable
{
	String name,address,ug,reg_course;
	int id,per;
	boolean flag;
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
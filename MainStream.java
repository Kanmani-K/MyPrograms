import java.io.*;
import java.io.Serializable;
class MainStream implements Serializable
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
//		CourseStream s[]=new CourseStream[];
		System.out.println("Enter no of Students: ");
		int n;
		n=Integer.parseInt(dis.readLine());
		CourseStream s[]=new CourseStream[n];
		for(int i=0;i<n;i++)
		{
		s[i]=new CourseStream();
		s[i].getDetail();
		System.out.println("hi");
		CourseStream s1=new CourseStream();
		s1=(CourseStream)s[i];
		try{out.writeObject(s1);}catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("hello");
		out.close();
		CourseStream s2=new CourseStream();
		System.out.println("Success");
		try{s2 =(CourseStream)in.readObject();}catch(Exception e){System.out.println(e);}
		if(s2.flag)
		{
		System.out.println("Student Code: " +s2.id);
		System.out.println("Name: " +s2.name);
		System.out.println("Address: " +s2.address);
		System.out.println("UnderGraduate Course: "+s2.ug);
		System.out.println("UnderGraduate Percentage: "+s2.per);
		System.out.println("Registered Course: "+s2.reg_course);
		}
		else
		{
		System.out.println("Sorry! You are not eligible Your details are not included");			
		}
	}
	}
} 
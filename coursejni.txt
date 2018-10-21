import java.io.*;

class CourseJNI

{
	String name,street,city,ug,reg_course;
	int cc,doorno,per,s1,s2,s3,s4,s5,s6;
	boolean flag;
	DataInputStream dis=new DataInputStream(System.in);
		
	void getDetails(int cc1,int cc2)throws IOException
	{
		cc=cc1;
		System.out.println("Enter name: ");
		name=dis.readLine();
		System.out.println("Enter Your UG Course: ");
		ug=dis.readLine();
		System.out.println("Enter your 6 semester percentages: ");
		System.out.print("For Semester 1:");
		s1=Integer.parseInt(dis.readLine());
		System.out.print("For Semester 2:");
		s2=Integer.parseInt(dis.readLine());
		System.out.print("For Semester 3:");
		s3=Integer.parseInt(dis.readLine());
		System.out.print("For Semester 4:");
		s4=Integer.parseInt(dis.readLine());
		System.out.print("For Semester 5:");
		s5=Integer.parseInt(dis.readLine());
		System.out.print("For Semester 6:");
		s6=Integer.parseInt(dis.readLine());		
		flag=eligible(s1,s2,s3,s4,s5,s6);
		if(flag==true)
		{
		System.out.println("\nEnter Your address: ");
		System.out.print("Doorno: ");
		doorno=Integer.parseInt(dis.readLine());
		System.out.print("\nStreet Name:");
		street=dis.readLine();
		System.out.print("\nCity Name:");
		city=dis.readLine();
		switch(cc2)
		{
		
			case 110:
				reg_course="Master of Computer Application";
				break;
			case 111:
				reg_course="Master of Computer Application-Lateral Entry";
				break;
			case 112:
				reg_course="Master of Engineering-ECE";
				break;

			case 113:
				reg_course="Master of Engineering-EEE";
				break;

		}
		System.out.println("SUCCESSFULLY REGISTERED");
		}
		else
			System.out.println("Sorry You are not eligible");

	}
	native boolean eligible(int s1,int s2,int s3,int s4,int s5,int s6);
	static{
	System.load("D://java and internet//JNI//CourseJNI//Debug//CourseJNI.dll");
	}
	void display()
	{
		if(flag==true)
		{
		System.out.println("Name: " +name);
		System.out.println("Student Code: " +cc);
		System.out.println("UnderGraduate Course: "+ug);
		/*System.out.println("Semester 1: " +s1);
		System.out.println("Semester 2: " +s2);
		System.out.println("Semester 3: " +s3);
		System.out.println("Semester 4: " +s4);
		System.out.println("Semester 5: " +s5);
		System.out.println("Semester 6: " +s6);*/
		System.out.println("Course Registered: "+reg_course);
		}
		else
		System.out.println("Sorry You are not eligible... So your details are not included");
					
	}
	void displayCourses()
	{
		System.out.println("1.Master of Computer application - 110");
		System.out.println("2.Master of Computer Application (Lateral Entry)-111");
		System.out.println("3.Mater of Engineering (ECE)-112");
		System.out.println("3.Mater of Engineering (EEE)-113");
		
		System.out.println("Kindly note your Course Code");
	}
	public static void main(String args[])throws IOException
	{
		CourseJNI d[]=new CourseJNI[50];
		CourseJNI d1=new CourseJNI();
		int choice;
		DataInputStream dis=new DataInputStream(System.in);
		do
		{	
		System.out.println("Enter your choice: ");
		System.out.println("1.Display Course");
		System.out.println("2.Registration");
		System.out.println("3.Display Details ");
		System.out.println("4.Exit");
		choice=Integer.parseInt(dis.readLine());
		switch(choice)
		{
			case 1:
				d1.displayCourses();
				break;
			
			case 2:
				System.out.println("Enter the number of students:");
				Integer n; 
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i< n;i++)
				{
				d[i]=new CourseJNI();
				System.out.println("Enter your Course Code: ");
				Integer coursecode;
				coursecode=Integer.parseInt(dis.readLine());
				System.out.println("Entering the detail of student " +(i+1) );
				d[i].getDetails(i+1,coursecode);
				}
				break;
			case 3:
				System.out.println("Enter the Student Code");
				Integer code1;
				code1=Integer.parseInt(dis.readLine());
				d[code1-1].display();
				break;

			case 4:
				System.exit(0);
				break;

			default:
				System.out.println("Ivalid choice try again later");
		}
		}while(choice!=4);
	}
}

import java.io.*;

class  Course
{
	String name,street,city,ug,reg_course;
	int id,doorno,per,total;
	int s[]=new int[6];
	DataInputStream dis;
	boolean flag;
		
	void getDetailsUG(int cc1)throws IOException
	{
		dis=new DataInputStream(System.in);
		try{
			System.out.println("Enter name: ");
			name=dis.readLine();	
			System.out.println("Enter Your UG Course: ");
			ug=dis.readLine();
			System.out.println("Enter your Semester Marks:");
			for(int i=0;i<6;i++){
				s[i]=Integer.parseInt(dis.readLine());
				total=s[i]+total;
			}
			per=total/6;	
			if(per<75){
				throw new EligibilityException("Not Eligible for registration");
				//flag=false;
			}
			else{
				System.out.println("Successfully registered...");
				flag=true;
			}				
		}
		catch(NumberFormatException e)
		{
			System.out.println("Here is a error, Again run the program");
			System.out.println(e);
		}
		catch(EligibilityException e)
		{
			System.out.println(e.getMessage());flag=false;
		}
		switch(cc1)
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
				reg_course="Master of Engineering-ECE";
				break;

			}
		
	}
	void displayCourses()
	{
		System.out.println("1.Master of Computer application - 110");
		System.out.println("2.Master of Computer Application (Lateral Entry)-111");
		System.out.println("3.Mater of Engineering (ECE)-112");
		System.out.println("3.Mater of Engineering (EEE)-113");
		System.out.println("Kindly note your Course Code");
	}
	void eligibility()
	{
		System.out.println("Eligibilty for the PG Courses: " +"\n For MCA: 80% and above" +"\n For MCA-Lateral Entry: 85% and above" +"\n 				For ME-ECE: 90% and above " +"\n For ME-EEE: 95% and above");
	}
	void display()
	{
		
		if(flag==true)
		{
		System.out.println("Name: " +name);
		System.out.println("UnderGraduate Course: "+ug);
		System.out.println("UnderGraduate Percentage: "+per);
		System.out.println("Student Code: " +id);
		System.out.println("Registered Course: "+reg_course);
		}
		else
		{
			System.out.println("Your details are not included");}
	}
}
class EligibilityException extends Exception
{
	String message;
	EligibilityException(String message)
	{
		super(message);
	}
}

class CourseException 
{
	public static void main(String args[])throws IOException
	{
		Course d[]=new Course[20];
		Course d1=new Course();
		int choice;
		DataInputStream dis=new DataInputStream(System.in);
		do
		{	
		System.out.println("Enter your choice: ");
		System.out.println("1.Display Course");
		System.out.println("2.Eligibility Criteria");
		System.out.println("3.Registration");
		System.out.println("4.Display Details");
		System.out.println("5.Exit");
		choice=Integer.parseInt(dis.readLine());
		switch(choice)
		{
			case 1:
				d1.displayCourses();
				break;
			
			case 2:
 				d1.eligibility();
				//System.out.println("                            Eligibilty for the PG Courses: "   +"\n For MCA: 80% and above" +"\n For MCA-Lateral Entry:85% and above" +"\n For ME-ECE: 90% and above " +"\n For ME-EEE: 95% and above");
				break;
			
			case 3:
				System.out.println("Enter the number of students:");
				Integer n; 
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i< n;i++)
				{
				d[i]=new Course();
				System.out.println("Enter your Course Code: ");
				Integer coursecode;
				coursecode=Integer.parseInt(dis.readLine());
				System.out.println("Entering the detail of student " +(i+1) );
				d[i].getDetailsUG(coursecode);
				}
				break;
			case 4:
				System.out.println("Enter the Student Code");
				Integer code1;
				code1=Integer.parseInt(dis.readLine());
				System.out.println("Enter the course Code");
				Integer code2;
				code2=Integer.parseInt(dis.readLine());
				d[code1-1].display();
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Ivalid choice try again later");
		}}while(choice!=5);
		}
}

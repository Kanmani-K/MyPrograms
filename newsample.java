import java.io.*;

class newsample
{
	String name,street,city,ug,reg_course;
	//String spec_exam[]=new String[5];
	int cc,doorno,per;
	//Integer spec_mark[]=new Integer[5];
	DataInputStream dis=new DataInputStream(System.in);
		
	void getDetailsUG(int cc1,int cc2)throws IOException
	{
		cc=cc1;
		System.out.println("Enter name: ");
		name=dis.readLine();
		System.out.println("Enter Your UG Course: ");
		ug=dis.readLine();
		System.out.println("Enter Your UG Percentage: ");
		per=Integer.parseInt(dis.readLine());
		/*System.out.println("Any additional courses are learnt: if Yes press y or press n ");
		char c;
		c=dis.readLine();
		if(c=='y' || c=='Y')
		{
			int n; 
			System.out.println("How many Exams Are Written ?");
			n=Integer.parseInt(dis.readLine());
			for(int i=0;i<n;i++)	
			{
			System.out.println("Enter the course name: ");
			spec_exam[i]=dis.readLine();
			System.out.println("Enter the marks scored in that exam");
			spec_mark[i]=Integer.parseInt(dis.readLine());
			}

		}*/
		
		switch(cc2)
		{
		
			case 110:
				if(per>=80)
				{
					System.out.println("Enter Your address: ");
					doorno=Integer.parseInt(dis.readLine());
					street=dis.readLine();
					city=dis.readLine();
					reg_course="Master of Computer Application";
					System.out.println("                                        You are Eligible to apply for this course:");
					System.out.println("                                         SUCCESSFULLY REGISTERED");
				}
				else
					System.out.println("Sorry! You are not eligible kindly check the eligibility criteria");
					break;
			case 111:
				if(per>=85)
				{
					reg_course="Master of Computer Application-Lateral Entry";
					System.out.println("Enter Your address: ");
					doorno=Integer.parseInt(dis.readLine());
					street=dis.readLine();
					city=dis.readLine();
					System.out.println("                         You are Eligible to apply for this course:");
					System.out.println("                          SUCCESSFULLY REGISTERED");
				}
				else
					System.out.println("Sorry! You are not eligible kindly check the eligibility criteria");
					System.out.println("Your Details are not included");

					break;
				
			case 112:
				if(per>=90)
				{
					reg_course="Master of Engineering-ECE";
					System.out.println("Enter Your address: ");
					doorno=Integer.parseInt(dis.readLine());
					street=dis.readLine();
					city=dis.readLine();
					System.out.println("You are Eligible to apply for this course:");
					System.out.println("SUCCESSFULLY REGISTERED");
				}
				else
					System.out.println("Sorry! You are not eligible kindly check the eligibility criteria");
					System.out.println("Your Details are not included");

					break;
	
			case 113:
				if(per>=90)
				{
					reg_course="Master of Engineering-ECE";
					System.out.println("You are Eligible to apply for this course:");
					System.out.println("SUCCESSFULLY REGISTERED");
				}
				else
					System.out.println("Sorry! You are not eligible kindly check the eligibility criteria");
					break;

			}
		

	}
	void display(int cc1,int cc2)
	{
		System.out.println("Name: " +name);
		System.out.println("UnderGraduate Course: "+ug);
		System.out.println("UnderGraduate Percentage: "+per);
		System.out.println("Student Code: " +cc);
		System.out.println("Registered Course: "+reg_course);
	}
	void displayCourses()
	{
		System.out.println("1.Master of Computer application - 110");
		System.out.println("2.Master of Computer Application (Lateral Entry)-111");
		System.out.println("3.Mater of Engineering (ECE)-112");
		System.out.println("3.Mater of Engineering (EEE)-113");
		
		System.out.println("Kindly note your Course Code");
	}
	/*void eligibility()
	{
		System.out.println("Eligibilty for the PG Courses: " +"\n For MCA: 80% and above" +"\n For MCA-Lateral Entry: 85% and above" +"\n For ME-ECE: 90% and above " +"\n For ME-EEE: 95% and above");
	}*/
	public static void main(String args[])throws IOException
	{
		newsample d[]=new newsample[20];
		newsample d1=new newsample();
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
				//d1.eligibility();
				System.out.println("Eligibilty for the PG Courses: " +"\n For MCA: 80% and above" +"\n For MCA-Lateral Entry: 85% and above" +"\n For ME-ECE: 90% and above " +"\n For ME-EEE: 95% and above");
				break;


				
			case 3:
				System.out.println("Enter the number of students:");
				Integer n; 
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i< n;i++)
				{
				d[i]=new newsample();
				System.out.println("Enter your Course Code: ");
				Integer coursecode;
				coursecode=Integer.parseInt(dis.readLine());
				System.out.println("Entering the detail of student " +(i+1) );
				d[i].getDetailsUG(i+1,coursecode);
				}
				break;
			case 4:
				System.out.println("Enter the Student Code");
				Integer code1;
				code1=Integer.parseInt(dis.readLine());
				System.out.println("Enter the course Code");
				Integer code2;
				code2=Integer.parseInt(dis.readLine());
				d[code1-1].display(code1+1,code2);
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Ivalid choice try again later");
		}}while(choice!=5);
		}
}

import java.io.*;

class  Course2
{
	String name,street,city;
	int doorno,per;long pno;
	DataInputStream dis;
		
	void detail()throws IOException
	{
		dis=new DataInputStream(System.in);
		System.out.println("\t\t\t\t\t\t\t\t\t\t Personal Details:");
		System.out.print("Name: ");
		name=dis.readLine();
		System.out.println("Enter Your Address:");
		System.out.print("Door No: ");
		doorno=Integer.parseInt(dis.readLine());
		System.out.print("Street Name: ");
		street=dis.readLine();
		System.out.print("City Name: ");
		city=dis.readLine();
		System.out.print("Mobile number: ");
		pno=Long.parseLong(dis.readLine());
	}
	void display(int eFlag)
	{
		if(eFlag==1)
		{
			System.out.println("                 Registered Details: ");
			System.out.println("Name: " +name);
			System.out.println("Address: ");
			System.out.print(doorno +"\n"+street +"\n" +city);
			System.out.println("Mobile Number: "+pno);
		}
		else
			System.out.println("             Sorry!!! Your are not Eligible due to Lower percentage");
	}
	void displayCourses()
	{
		System.out.println("Under Graduate Courses:");
		System.out.println("BSC(C.S)"	+"\nBSC(C.S & I.T)"	+"\nBSC(I.T)" +"\nBCA" +"\nBSC(C.C.N)"	+"\nBSC(E.C.S)"  +"\nBE(EEE)"	+"\nBE(ECE)"+"\nBE(CS)");    
		System.out.println("Post Graduate Courses: ");
		System.out.println("MCA(LE)" +"\nMCA" +"\nMSC(C.S)" +"\nMSC(C.S & I.T)" +"\nMSC(I.T)" +"\nMSC(C.C.N)"+"\nMSC(E.C.S)" +"\nME(EEE)"+"\nME(ECE)"+"\nME(CS)");
	}
}	
class UGCourse2 extends Course implements OnlinePayment
{
	
	int mark12,mark10,per12,per10,eligible_flag;
	String ug_course;boolean pay;
	void getDetailsUG() throws IOException
	{
		detail();
		dis=new DataInputStream(System.in);
		System.out.println("             Qualification Details:");
		System.out.println("10 mark Percentage:");
		per10=Integer.parseInt(dis.readLine());
		System.out.println("12 mark Percentage:");
	 	per12=Integer.parseInt(dis.readLine());	
		System.out.println("             Course Details:");
		System.out.println("UG Course: ");
		ug_course=dis.readLine();
		eligible_flag=checkEligibility();
	}
	int checkEligibility()
	{
		if(per12>=85)
			return 1;
		else
			return 0;
	}

	void displayUG(){
		display(eligible_flag);
		if(eligible_flag==1)
		{
			System.out.println("    10 %: " +per10);
			System.out.println("    12 %: " +per12);
			System.out.println("    UG Course: " +ug_course);
			payment();
		}
		
	}
	public void payment()
	{
		
		try {/*DataInputStream*/ dis=new DataInputStream(System.in);
		System.out.println("WELCOME TO THE PAYMENT SECTOR" +"\nChoose the payment mode" +"\n1.Card Payment" +"\n2.Manual Payment");
		int code=Integer.parseInt(dis.readLine());
		if(code==1)
		{
			System.out.println("Registration fee for any UG Course: Rs.500");		
			System.out.println("Choose your card: " +"\n1.visa card" +"\n2.Mastero card" +"\n3.Rupey" );
			int choice1=Integer.parseInt(dis.readLine());
			System.out.println("Enter the name on the card: ");
			String card_name=dis.readLine();
			System.out.println("Enter the One time password: ");
			Integer otp=Integer.parseInt(dis.readLine());
			System.out.println("Payment done for the Student : "+name+"\n Course: " +ug_course +"\nAmount: Rs.500");
			
		}
		else if(code==2)
		{
			System.out.println("\nMethod for Manual Payment:" +"\n1.Go to the College Office"+"\n2.Get the chalan"+"\n3.Fill the details in the chalan" +"\n4.Hand over to the office");
		}
	System.out.println("Thank You");	}catch (Exception e){}
	}
} 
class PGCourse2 extends Course implements OnlinePayment
{
	int ug_mark,eligible_flag,ug_per;
	String ug_course,pg_course;
	public void payment()
	{
		
		try{
		/*DataInputStream*/ dis=new DataInputStream(System.in);
		System.out.println("WELCOME TO THE PAYMENT SECTOR" +"\nChoose the payment mode" +"\n1.Net Banking" +"\n2.Card Payment" +"\n3.Manual Payment");
		int code=Integer.parseInt(dis.readLine());
		if(code==1)
		{
			System.out.println("Registration fee for any PG Course: Rs.1000");		
			System.out.println("Choose your card: " +"\n1.visa card" +"\n2.Mastero card" +"\n3.Rupey" );
			int choice1=Integer.parseInt(dis.readLine());
			System.out.println("Enter the name on the card: ");
			String card_name=dis.readLine();
			System.out.println("Enter the One time password: ");
			Integer otp=Integer.parseInt(dis.readLine());
			System.out.println("Payment done for the Student : "+name+"\n Course: " +pg_course +"\nAmount: Rs.1000");
			
		}
		else if(code==2)
		{
			System.out.println("\nMethod for Manual Payment:" +"\n1.Go to the College Office"+"\n2.Get the chalan"+"\n3.Fill the details in the chalan" +"\n4.Hand over to the office");
		}
	System.out.println("Thank You");	}catch(Exception e){}
	}

	void getDetailsPG() throws IOException
	{
		detail();
		dis=new DataInputStream(System.in);
		System.out.println("                         Qualification Details:");
		System.out.print("Enter Your UG Course:");
		ug_course=dis.readLine();
		System.out.print("Enter your UG Percentage:");
	 	ug_per=Integer.parseInt(dis.readLine());	
		System.out.println("                        Course Details:");
		System.out.print("PG Course: ");
		pg_course=dis.readLine();
		eligible_flag=checkEligibility();
	}
	int checkEligibility()
	{
		if(ug_per>=85)
			return 1;
		else
			return 0;
	}

	void displayPG(){
		display(eligible_flag);
		if(eligible_flag==1)
		{
			System.out.print("           UG Course: " +ug_course);
			System.out.print("           UG Percentage: " +ug_per);
			System.out.print("           PG Course: "+pg_course );payment();
		}
	
		
}	
} 	
interface OnlinePayment
{
	void payment();
}

class Multiplenheritance
{
	public static void main(String args[])throws IOException
	{
		PGCourse2 obj2[]=new PGCourse2[20];
		//PGCourse obj22=new PGCourse();
		UGCourse2 obj1[]=new UGCourse2[20];
		//UGCourse obj12=new UGCourse2();
		Course2 obj=new Course2();
		int choice,n;
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println(" \n                 Welcome to the Online Registration for TCE");
		do
		{	
		System.out.println("Enter your choice: ");
		System.out.println("1.Display Courses");
		//System.out.println("2.Eligibility Criteria");
		System.out.println("2.Registration for Under Graduate");
		System.out.println("3.Display details for Under Graduate");
		System.out.println("4.Registration for Post Graduate");
		System.out.println("5.Display details for Post Graduate");
		System.out.println("6.Exit");
		choice=Integer.parseInt(dis.readLine());
		switch(choice)
		{
			case 1:
				obj.displayCourses();
				break;
			/*case 2:
				obj.eligibility();
				break;*/
			case 2:
				System.out.println("Enter the number of students:");
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i< n;i++)
				{
				obj1[i]=new UGCourse2();
				System.out.println("Entering the detail of student " +(i+1) );
				obj1[i].getDetailsUG();
				}
				break;
				
			case 3:
				System.out.println("Enter the Student Code:");
				int code;
				code=Integer.parseInt(dis.readLine());
				obj1[code-1].displayUG();
				break;
		
			case 4:
				System.out.println("Enter the number of students:");
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i< n;i++)
				{
				obj2[i]=new PGCourse2();
				System.out.println("Entering the detail of student " +(i+1) );
				obj2[i].getDetailsPG();
				}
				break;

			case 5:
				System.out.println("Enter the Student Code:");
				int code1;
				code1=Integer.parseInt(dis.readLine());
				obj2[code1-1].displayPG();
				break;
			
			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Ivalid choice try again later");
		}}while(choice!=6);
		}
}

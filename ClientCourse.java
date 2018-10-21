import java.net.*;
import java.io.*;
import java.util.NoSuchElementException;
class ClientCourse
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		int choice;
/*		System.out.println("Enter your choice: ");
		System.out.println("1.Display Course");
		System.out.println("2.Registration");
		System.out.println("3.Exit");
		choice=Integer.parseInt(in.readLine());
		switch(choice)
		{
			case 1:*/
				displayCourses();
				/*break;
			case 2:
				System.out.println("Entering the detail of student " +(i+1) );*/
				getDetails();
				/*break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Ivalid choice try again later");
		}}while(choice!=3);*/
	
	}
	static void getDetails()throws IOException
	{
		String ch="no";
		try{
		Socket socket=new Socket("localhost",5000);
		System.out.println("\nConnected");
		DataInputStream ins=new DataInputStream(socket.getInputStream());
		DataOutputStream outs=new DataOutputStream(socket.getOutputStream());
		String name,address,reg_course,ug,line;
		int id,per;
		long pno;
		int flag=0;
		DataInputStream in=new DataInputStream(System.in);
		do{
		System.out.println("Enter the details: ");
		System.out.println("\t\t\t\t\t\t\t\t\t\t Personal Details:");
		System.out.print("Name: ");
		name=in.readLine();
		System.out.println("Enter Your Address:");
		address=in.readLine();
		System.out.print("Mobile number: ");
		pno=Long.parseLong(in.readLine());
		System.out.print("UG course: ");
		ug=in.readLine();
		System.out.print("UG percentage: ");
		per=Integer.parseInt(in.readLine());
		System.out.println("Enter your course: ");
		reg_course=in.readLine();
		outs.writeUTF(String.valueOf(per));
		flag=Integer.parseInt(ins.readUTF());
		if(flag==1)
		{
			System.out.println("                 Registered Details: ");
			System.out.println("Name: " +name);
			System.out.println("Address: "+address);
			System.out.println("Mobile Number: "+pno);
			System.out.println("UG Course : " +ug);
			System.out.println("percentage : " +per);
			System.out.println("PG Course : " +reg_course);
		}
		else
			System.out.println("             Sorry!!! Your are not Eligible due to Lower percentage");
		System.out.println("Is there any students to register? yes/no");
		ch=in.readLine();
		outs.writeUTF(ch);
		if(ch.equals("no"))
		{
			socket.close();
			System.out.println("\n\nDisconnected");
		}
		}while(ch.equals("yes"));}
		catch(Exception u)
		{
			System.out.println(u);
		}
	}
	static void displayCourses()
	{
		System.out.println("Courses: ");
		System.out.println("MCA(LE)" +"\nMCA" +"\nMSC(C.S)" +"\nMSC(C.S & I.T)" +"\nMSC(I.T)" +"\nMSC(C.C.N)"+"\nMSC(E.C.S)" +"\nME(EEE)"+"\nME(ECE)"+"\nME(CS)");
	}
} 
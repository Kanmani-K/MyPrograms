import java.io.*;
class CourseThread
{
	String name,city,ug,reg_course;
	int cc,total,avg;
	int sem[]=new int[6];
	boolean flag;
	DataInputStream dis=new DataInputStream(System.in);
	void getDetails()throws IOException
	{
		System.out.println("Enter name: ");
		name=dis.readLine();
		System.out.println("Enter Your UG Course: ");
		ug=dis.readLine();
		System.out.println("Enter your 6 semester percentages: ");
		for(int i=0;i<6;i++)
		{
			System.out.print("For Semester " +(i+1) +":");
			sem[i]=Integer.parseInt(dis.readLine());
		}
		System.out.println("Enter the course code: ");
		cc=Integer.parseInt(dis.readLine());
		System.out.println("\nEnter Your address: ");
		/*System.out.print("Doorno: ");
		doorno=Integer.parseInt(dis.readLine());
		System.out.print("\nStreet Name:");
		street=dis.readLine();*/
		System.out.print("\nCity Name:");
		city=dis.readLine();
		switch(cc)
		{
		
			case 110:
				reg_course="EEE";
				break;
			case 111:
				reg_course="ECE";
				break;
			case 112:
				reg_course="CS & IT";
				break;
			case 113:
				reg_course="CIVIL";
				break;
		}
				
	}
	void displayCourses()
	{
		System.out.println("1.ME-EEE -----> 110");
		System.out.println("2.ME-ECE -----> 111");
		System.out.println("3.ME-(CS &IT)------>112");
		System.out.println("3.ME-(CIVIL)------>113");
		System.out.println("Kindly note your Course Code");
	}
	synchronized void calc(int s[],String rc,CourseThread obj)
	{
		System.out.println("Calling Synchronized Function.......");
		int sum=0;
		for(int i=0;i<6;i++)
		{
			sum=sum+s[i];
		}	
		obj.total=sum;
		obj.avg=total/6;
		if ((avg>75 && rc.equals("EEE")) || (avg>80 && rc.equals("ECE")) || (avg>85 && rc.equals("CS & IT")) || (avg>90 && rc.equals("CIVIL")))
		{
			System.out.println("Successfully Register....");
			obj.flag=true;
		}
		else {
			System.out.println("You are not eligible...");
			obj.flag=false;
		}
		try{
		System.out.println("Making Thread sleep......");
		 Thread.sleep(1000);}catch(Exception e){}
		//display();
	}
	void display()
	{
		if(flag)
		{
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println("---------------------STUDENT'S DETAIL-------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("NAME			:"+name);
			System.out.println("UG COURSE		:"+ug);
			System.out.println("UG PERCENTAGE		:"+avg);
			System.out.println("REGISTERED COURSE	:"+reg_course);
		}
		else
		{
			System.out.println("SORRY!!!!! DUE TO THE ELIGIBILITY CRITERIA YOUR APPLICATION IS REJECTED");
		}
	}
}
class ThisIsThread implements Runnable
{
	CourseThread obj1;
	int s[ ]=new int[6];
	String msg;
	Thread t;
	public ThisIsThread(int marks[],String rc,CourseThread obj)
	{
		obj1=obj;
		s=marks;
		msg=rc;
		t=new Thread(this);
		t.start();
		System.out.println("Starting thread.....");
	}
	public void run() 
	{
//		synchronized(obj1)
//		{
//			System.out.println("Entering into Synchronized Block................");
			obj1.calc(s,msg,obj1);
			obj1.display();
//		}
	}
}
class MainClass
{
	public static void main(String args[])throws IOException
	{
		CourseThread stu1=new CourseThread();
		CourseThread stu2=new CourseThread();
		CourseThread d=new CourseThread();
		CourseThread stu3=new CourseThread();
		System.out.println("------------------------------Welcome to the Course Registration------------------");
		System.out.println("Courses");	
		d.displayCourses();
		stu1.getDetails();
		stu2.getDetails();
		//stu3.getDetails();
		/*try
		{
			t1.t.join();t2.t.join();//obj3.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted");
		}*/
		ThisIsThread t1=new ThisIsThread(stu1.sem,stu1.reg_course,stu1);
		ThisIsThread t2=new ThisIsThread(stu2.sem,stu2.reg_course,stu2);
		}
}		
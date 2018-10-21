import java.io.*;
import java.sql.*;
class CourseJDBC
{
	String name,gender,ug,pg,address;
	int age,per;
	static int id=1;	
	DataInputStream in;
	void displayCourse()throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from courses");
		while(rs.next())
		{
			System.out.println("Course Name       "+"Course code\n" +rs.getString(1) +"         " +rs.getInt(2));				
		}	
	}
	void register()throws Exception
	{
		in=new DataInputStream(System.in);
		System.out.println("Enter your details: ");
		System.out.print("Name :");
		name=in.readLine();
		System.out.print("\nGender :");
		gender=in.readLine();
		System.out.print("\nAge :");
		age=Integer.parseInt(in.readLine());
		System.out.print("\nAddress :");
		address=in.readLine();
		System.out.print("\nUG Course :");
		ug=in.readLine();
		System.out.print("\nUG Percentage: ");
		per=Integer.parseInt(in.readLine());
		System.out.print("\nPG Course: ");
		pg=in.readLine();
		if(per>75)
		{
			String query="insert into PGStudents (id,name,gender,age,address,ug,per,pg) values(?,?,?,?,?,?,?,?)";
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,gender);
			ps.setInt(4,age);	
			ps.setString(5,address);	
			ps.setString(6,ug);
			ps.setInt(7,per);
			ps.setString(8,pg);
			System.out.println("Your information is updated");
			System.out.println("Note your Id: " +id);
			id++;
			ps.executeUpdate();
		}
		else
			System.out.println("Your information is not updated because you are not eligible to apply for this course");
				
	}
	void display(int i)throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from PGStudents where id=" +i);
		while(rs.next()){
		System.out.println("ID: " +rs.getInt(1));
		System.out.println("NAME: " +rs.getString(2));
		System.out.println("GENDER: " +rs.getString(3));
		System.out.println("AGE: " +rs.getInt(4));
		System.out.println("ADDRESS: " +rs.getString(5));
		System.out.println("UG: " +rs.getString(6));		
		System.out.println("PERCENTAGE: " +rs.getInt(7));
		System.out.println("PG COURSE: " +rs.getString(8));}
	}
	public static void main(String args[])throws Exception
	{
		DataInputStream dis=new DataInputStream(System.in);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e){System.out.println(e.getMessage());}
		CourseJDBC c1=new CourseJDBC();
		int n;
		int choice;
		do
		{	
		System.out.println("Enter your choice: ");
		System.out.println("1.Display Course");
		System.out.println("2.Registration");
		System.out.println("3.Display Details");
		System.out.println("4.Exit");
		choice=Integer.parseInt(dis.readLine());
		switch(choice)
		{
	 		case 1:
				c1.displayCourse();
				break;
			
			case 2:
				System.out.println("Enter the number of students: ");
				n=Integer.parseInt(dis.readLine());
				for(int i=0;i<n;i++)
				{
					c1.register();
				}
				break;
			case 3:
				System.out.println("Enter your student id: ");
				int i;
				i=Integer.parseInt(dis.readLine());
				c1.display(i);
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

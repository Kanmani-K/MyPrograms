import java.lang.*;
import java.io.*;
import java.sql.*;
class sales
{
	int id,exp;
	String name;
	int salary;
	int basicsalary,incentive;
	void get()throws IOException
	{
		 
		try
		{Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println ("Enter Employee id");
		id = Integer.parseInt(br.readLine());

		System.out.println ("Enter Employee Name");
		name = br.readLine();

		System.out.println ("Enter Basic Salary");
		basicsalary = Integer.parseInt(br.readLine());

		System.out.println("Enter experience");
		exp=Integer.parseInt(br.readLine());

		System.out.println("HHH");
		if (exp==1)
	                incentive = 1000+basicsalary;
                else if (exp ==2)
            	        incentive = 2000+ basicsalary;		
		else if (exp==3)
			incentive=3000 + basicsalary;
		else if(exp==4)
			incentive=4000 + basicsalary;
		else if(exp==5)
			incentive=5000 + basicsalary;
		else 
			incentive=7000 + basicsalary;
		int da=basicsalary*15/100;
		int hra=basicsalary*10/100;
		int gross_sal=basicsalary+da+hra;
		salary=incentive+gross_sal;
		String query="insert into employee (id,name,bp,exp,salary) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,basicsalary);
		ps.setInt(4,exp);	
		ps.setInt(5,salary);
		System.out.println("Inserted");
		ps.executeUpdate();
		/*Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		PreparedStatement ps1=con.prepareStatement("update employee set salary = ? where id= ?");
		ps1.setInt(5,salary);
		ps1.setInt(1,id);*/
		System.out.println("Employee details");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee where id=id");
		while(rs.next()){
		System.out.println("ID: " +rs.getInt(1));
		System.out.println("NAME: " +rs.getString(2));
		System.out.println("BASIC SALARY: " +rs.getInt(3));
		System.out.println("EXPERIENCE: " +rs.getInt(4));
		System.out.println("SALARY: " +rs.getInt(5));
		}
		con.close();
		}
		catch(Exception e){System.out.println(e);}
			
	}
}

class employee
{
	public static void main(String args[])throws IOException
	{
		int i,n;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e){System.out.println(e.getMessage());}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sales e=new sales();
		System.out.println("Enter the no.of employees:");
		n= Integer.parseInt(br.readLine());
		for(i=0;i<n;i++)
		{
		//e[i]=new sales();
		e.get();
                }
		//con.close();
	}
}
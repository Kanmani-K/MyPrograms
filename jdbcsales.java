import java.io.*;
import java.sql.*;
class jdbcsales
{
public static void main(String args[])throws Exception
{
	
	jdbcsales s = new jdbcsales();
	int id,exp,basicsalary,salesamount,incentive,m,salary;
	String name;
	Connection con;
	Statement stmt;
	//ResultSet rs;
	DataInputStream d;
	try{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		stmt=con.createStatement();
	
		
	do
	{
		System.out.println("1 : Create table \n2 : Insert details  \n3 : Update information  \n4 : Delete record \n5 : Display salarydetails 6-Exit");
		d = new DataInputStream(System.in);
		System.out.print("Enter your choice = ");
		int choice=Integer.parseInt(d.readLine());
		switch(choice)
		{
		case 1:
			d = new DataInputStream(System.in);
			System.out.print("Enter the table name =(jdbcsales) ");
			String tname;
			tname=d.readLine();
			stmt.executeQuery("create table jdbcsales(id number,name varchar(10),basicsalary number,exp number, salesamount number, incentive number, salary number)");
			System.out.println("Table created");
			break;

		case 2:
			d = new DataInputStream(System.in);
			System.out.print("Enter number of salesperson = ");
			int no=Integer.parseInt(d.readLine());
			for(int j=0;j<no;j++)
			  {
				System.out.println("Insert Customer datails");
				System.out.print("Enter the employee id = ");
				id=Integer.parseInt(d.readLine());
				System.out.print("Enter the name = ");
				name=d.readLine();
				System.out.print("Enter basicsalary = ");
				basicsalary=Integer.parseInt(d.readLine());
				System.out.print("Enter Exp =");
				exp=Integer.parseInt(d.readLine());
				System.out.print("Enter salesamount = ");
				salesamount=Integer.parseInt(d.readLine());					
					if (salesamount>=1000&&salesamount<=2000)
						incentive = 1000;
	                else if (salesamount>=2001&&salesamount<=3000)
            		    incentive = 2000;		
					else if (salesamount>=3001&&salesamount<=4000)
						incentive = 3000;
					else if(salesamount>=4001&&salesamount<=5000)
						incentive = 4000;
					else if(salesamount>=5001&&salesamount<=8000)
						incentive = 5000;
					else 
						incentive = 7000;
						int da=basicsalary*15/100;
						int hra=basicsalary*10/100;
						int pf=basicsalary*10/100;
						int it=basicsalary*10/100;
						int gross_sal=basicsalary+da+hra;
						salary=incentive+gross_sal-pf-it;
				System.out.println("after salary");
				PreparedStatement ps = con.prepareStatement("insert into jdbcsales values(?,?,?,?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setInt(3,basicsalary);
				ps.setInt(4,exp);
				ps.setInt(5,salesamount);
				ps.setInt(6,incentive);
				ps.setInt(7,salary);
				ps.executeUpdate();
				System.out.println("Detail inserted");
			}
			break;
			case 3:
				d = new DataInputStream(System.in);
				System.out.print("Enter the customer id = ");
				int uid= Integer.parseInt(d.readLine());
				System.out.println("1:name,2:salesamount");
				System.out.print("enter which field you going to update");
				int field=Integer.parseInt(d.readLine());
				if(field==1)
				{
						System.out.println("Enter name");
						String uname=d.readLine();
						PreparedStatement ps3 = con.prepareStatement("update jdbcsales set name=? where id=?");
						ps3.setString(1,uname);
						ps3.setInt(2,uid);
						System.out.println("Updated Successfully");
						ps3.executeUpdate();
				}
				if(field==2)
				{
						System.out.println("Enter basicsalary");
						int ubasicsalary=Integer.parseInt(d.readLine());
							System.out.print("Enter salesamount = ");
						int ssalesamount=Integer.parseInt(d.readLine());	
						int iincentive;
					if (ssalesamount>=1000&&ssalesamount<=2000)
						iincentive = 1000;
	                else if (ssalesamount>=2001&&ssalesamount<=3000)
            		    iincentive = 2000;		
					else if (ssalesamount>=3001&&ssalesamount<=4000)
						iincentive = 3000;
					else if(ssalesamount>=4001&&ssalesamount<=5000)
						iincentive = 4000;
					else if(ssalesamount>=5001&&ssalesamount<=8000)
						iincentive = 5000;
					else 
						iincentive = 7000;
			
						int da=ubasicsalary*15/100;
						int hra=ubasicsalary*10/100;
						int pf=ubasicsalary*10/100;
						int it=ubasicsalary*10/100;
						int gross_sal=ubasicsalary+da+hra;
					    salary = iincentive + gross_sal-(pf+it);
						PreparedStatement ps1 = con.prepareStatement("update jdbcsales set basicsalary=? where id=?");
						ps1.setInt(1,ubasicsalary);
						ps1.setInt(2,uid);
						System.out.println("Updated Successfully");
						ps1.executeUpdate();
				}
				break;

			case 4:
				System.out.println("\n");
				d = new DataInputStream(System.in);
				System.out.print("Enter the employee id = ");
				int iid = Integer.parseInt(d.readLine());
				PreparedStatement ps2 = con.prepareStatement("delete from jdbcsales where id="+iid);
				int rows = ps2.executeUpdate();
				System.out.println("record deleted");
				break;
			case 5:
				try{d = new DataInputStream(System.in);
				/*System.out.print("Enter the customer id = ");
				int i = Integer.parseInt(d.readLine());*/
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("Select * from jdbcsales"); // where id="+i);
				System.out.println("\tid\tname\tbasicsalary\texp\tsalesamount\tincentive\tsalary");
				System.out.println("-------------------------------------------------------------------");
				while(rs.next())
				{
				id=rs.getInt(1);
				name=rs.getString(2);
				basicsalary=rs.getInt(3);
				salesamount=rs.getInt(5);
				exp=rs.getInt(4);
				incentive=rs.getInt(6);
				salary=rs.getInt(7);
				System.out.println("\t"+id+"\t"+name+"\t"+basicsalary+"\t"+exp+"\t"+salesamount+"\t"+incentive+"\t"+salary);
				}}catch(Exception e){System.out.println(e);}
			break;
		}
		System.out.println("If you want to continue press 1");
		m=Integer.parseInt(d.readLine());
	}while( m==1);
		con.close();
		stmt.close();
	}
	catch(SQLException e)
		{
			e.getMessage();
		}
}
}
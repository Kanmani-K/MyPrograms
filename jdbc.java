import java.io.*;
import java.sql.*;
class Scheme
{

	void display()throws Exception
	{
	System.out.println("Package available");
	System.out.println("1. News - 100");
	System.out.println("2. Music - 200");
	System.out.println("3. Sports - 300");
        System.out.println("4. Cartoon - 400");
	}
	
	
}
class jdbc
{
public static void main(String args[])throws Exception
{
	
	Scheme s = new Scheme();
	int c_id,n,total=0,amount=0,i,ch,choice,row,rcd;
	String cname,place,isql,csql,ssql,dsql,sssql,usql,t_name;
	Connection con;
	Statement stmt;
	ResultSet rs;
	DataInputStream d;
	try{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		stmt=con.createStatement();
	
		
	do
	{
		System.out.println("1-Create 2-Insert 3-Update 4-Delete 5-Display 6-Exit");
		d = new DataInputStream(System.in);
		System.out.print("Enter your choice = ");
		choice=Integer.parseInt(d.readLine());
		switch(choice)
		{
		case 1:
			System.out.println("==========Table Creation========");
			d = new DataInputStream(System.in);
			System.out.print("Enter the table name = ");
			t_name=d.readLine();
			csql="create table scheme(c_id number,c_name varchar(10),place varchar(10),total number)";
			stmt.executeUpdate(csql);
			System.out.println("Table created");
			break;

		case 2:
			d = new DataInputStream(System.in);
			System.out.print("Enter the no of customers to add = ");
			int limit=Integer.parseInt(d.readLine());
			for(int j=0;j<limit;j++)
			  {
				System.out.println("==========Insert Customer datails========");
	
			System.out.print("Enter the customer id = ");
			c_id=Integer.parseInt(d.readLine());
			System.out.print("Enter the name = ");
			cname=d.readLine();
			System.out.print("Enter the residence city = ");
			place=d.readLine();
			s.display();
			System.out.print("Enter the no of pack needed = ");
			n=Integer.parseInt(d.readLine());
			for(i=0;i<n;i++)
			  {
				
				System.out.print("Enter your choice = ");
				ch=Integer.parseInt(d.readLine());
			switch(ch)
	    			{
				case 1:
					total=total+100;
					
					break;
				case 2:
					total=total+200;
					
					break;
				case 3:
					total=total+300;
					
					break;
				case 4:
					total=total+400;
					
					break;
	    			}
				
			}
				System.out.println("Total amount = "+total);
				isql="insert into scheme values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(isql);
				ps.setInt(1,c_id);
				ps.setString(2,cname);
				ps.setString(3,place);
				ps.setInt(4,total);
				row = ps.executeUpdate();
				System.out.println(row +" row inserted");
				total=0;
			}
				break;
			case 3:
				System.out.println("==========Customer record Updation========");
				d = new DataInputStream(System.in);
				System.out.println("***** Rs.100 discount *****");
				System.out.print("Enter the customer id = ");
				int cids = Integer.parseInt(d.readLine());
				//amount = total-100;
				usql="update scheme set total=? where c_id="+cids;
				
				PreparedStatement ps3 = con.prepareStatement(usql);
				System.out.println("Updated Successfully");
				ps3.setInt(1,100);
				ps3.executeUpdate();
				break;

			case 4:
				System.out.println("\n");
				System.out.println("==========Customer record deletion========");
				d = new DataInputStream(System.in);
				System.out.print("Enter the customer id = ");
				int cid = Integer.parseInt(d.readLine());
				dsql="delete from scheme where c_id="+cid;
				PreparedStatement ps2 = con.prepareStatement(dsql);
				int rows = ps2.executeUpdate();
				System.out.println(rows +" deleted");
			
				break;
			case 5:
				//System.out.println("\n");
				System.out.println("==========Display record========");
				d = new DataInputStream(System.in);
				System.out.println("To view particular customer press 1");
				System.out.println("To view complete record press 2");
				System.out.print("View choice = ");
				rcd=Integer.parseInt(d.readLine());
			if(rcd==1)
			{
				System.out.print("Enter the customer id = ");
				int id = Integer.parseInt(d.readLine());
				ssql="Select *from scheme where c_id="+id;
				PreparedStatement ps1 = con.prepareStatement(ssql);
				rs = ps1.executeQuery();
				System.out.println("\t Cid\tCname\tResidence\tTotal");
				System.out.println("--------------------------------------------------------");
			while(rs.next())
	 		 {
				c_id=rs.getInt(1);
				cname=rs.getString(2);
				place=rs.getString(3);
				total=rs.getInt(4);
				System.out.println("\t"+c_id+"\t"+cname+"\t"+place+"\t\t"+total);
	  		}
			}
			else if(rcd==2)
			{
				sssql="Select *from scheme";
				PreparedStatement ps1 = con.prepareStatement(sssql);
				rs = ps1.executeQuery();
				System.out.println("\t Cid\tCname\tResidence\tTotal");
				System.out.println("--------------------------------------------------------");
			while(rs.next())
	 		 {
				c_id=rs.getInt(1);
				cname=rs.getString(2);
				place=rs.getString(3);
				total=rs.getInt(4);
				System.out.println("\t"+c_id+"\t"+cname+"\t"+place+"\t\t"+total);
	  		}
			}
			break;
		} 
		System.out.println("\n");
		}while(choice!=6);
	
	
		con.close();
		stmt.close();
		}
	
		catch(SQLException e)
		{
			e.getMessage();
		}
	    }
	}

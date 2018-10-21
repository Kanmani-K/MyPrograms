import java.net.*;
import java.io.*;
 
public class ServerCourse
{
	public static void main(String args[])
	{
		detailFromClient();
	}
	static void detailFromClient()
	{
		try{
		ServerSocket server=new ServerSocket(5000);
		System.out.println("\n\nServer started");
		System.out.println("\n\nWaiting for a client....");
		Socket socket=server.accept();
		System.out.println("\n\nClient accepted...");
		DataInputStream in=new DataInputStream(socket.getInputStream());
		DataOutputStream out=new DataOutputStream(socket.getOutputStream());
		String ch="no";
		do{
		System.out.println("\n\nGetting Information from the clients...");
		int per;
		per=Integer.parseInt(in.readUTF());
		if(per>75){
			out.writeUTF(String.valueOf(1));
			System.out.println("\n\nReturned from the server... ");
		}
		else
		{
			out.writeUTF(String.valueOf(0));
			System.out.println("\n\nReturned from the server...");
		}
		ch=in.readUTF();
		if(ch.equals("yes"))
			System.out.println("\n\nEnterring the detail for another student....");
		else{
			server.close();
			socket.close();
			System.out.println("\n\nDisconnected");
		}
		}while(ch.equals("yes"));}
		catch(Exception e){System.out.println(e);}
	}
}

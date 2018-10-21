import java.io.*;
import java.io.FileWriter;
import java.util.*;
class Stream
{
String str;
FileWriter fw,fw1;
FileReader fr;
DataInputStream dis;
BufferedReader br,br1;
static int count=0;
void writefile()throws IOException
{
try
{
fw=new FileWriter("Sara.txt");
dis=new DataInputStream(System.in);
System.out.println("Enter the String to write into the file");
str=dis.readLine();
fw.write(str);
fw.close();
}
catch(FileNotFoundException e)
{
System.out.println(e.getMessage());
}
catch(IOException e)
{
System.out.println(e.getMessage());
}
}
void length()throws IOException
{
try
{
String s;
fr=new FileReader("Sara.txt");
br=new BufferedReader(fr);
int i;
while((s=br.readLine())!=null){
//System.out.println(s);
for( char c:s.toCharArray())
{
	//System.out.print(c);
	count++;
}
System.out.println("\nLength of the File:" +count);
}

}
catch(FileNotFoundException e)
{
System.out.println(e.getMessage());
}
}
void reverse()throws IOException
{
	try
	{
		String s;
		fr=new FileReader("Sara.txt");
		br=new BufferedReader(fr);
		while((s=br.readLine())!=null){
		for(int i=count-1;i>=0;i--)
		{
		System.out.print(s.charAt(i));	
		}	
		}}catch(Exception e){}

		
}
void concat()throws IOException
{
                System.out.println("Enter the String to be concated");
		String con,con1;
		try
		{
		String s;
		dis=new DataInputStream(System.in);
		System.out.println("\nEnter any String to be concatenated: ");
		con=dis.readLine();
		fr=new FileReader("Sara.txt");
		br=new BufferedReader(fr);
		s=br.readLine();
		con1=s+con;
		System.out.println(con1);
		}catch(Exception e){}
}
void count()throws IOException
{
	try{
	String s;
	fr=new FileReader("Sara.txt");
	br=new BufferedReader(fr);
	int c=0;
	s=br.readLine();
	String words[]=s.split(" ");	
	for(String w:words)
	{
		c++;
	}
	System.out.println("The number of words in the file: " +c);
	}catch(Exception e){}
}
void findAndReplace()
{
try{
	String s;
	fr=new FileReader("Sara.txt");
	br=new BufferedReader(fr);
	fw1=new FileWriter("Replaced.txt");
	dis=new DataInputStream(System.in);
	int c=0;
	s=br.readLine();
	String words[]=s.split(" ");	
	String find,replace;
	System.out.println("Enter the word to be find in the file: ");
	find=dis.readLine();
	System.out.println("Enter the word to be replaced: ");
	replace=dis.readLine();
	for(String w:words)
	{
		if(find.equals(w))
		{
			fw1.write(replace);fw1.write(" ");
		}
		else
		{
			System.out.println(w);fw1.write(" ");
			fw1.write(w);
		}	
	}fw1.close();
	}catch(Exception e){System.out.println(e);}
	System.out.println("Replaced successfully....");
	
}
public static void main(String ar[])throws IOException
{
Stream s=new Stream();
DataInputStream dis=new DataInputStream(System.in);
int c=1,ch;
System.out.println("\t\t\t\tString Functions\n\t\t\t\t-------------------------");
while(c!=0)
{
System.out.println("1.write\t2.Length\t3.Reverse\t4.concat\t5.Count words\t6.Find&Replace\nEnter Your choice:");
ch=Integer.parseInt(dis.readLine());
switch(ch)
{
case 1:
s.writefile();
break;
case 2:
s.length();
break;
case 3:
s.reverse();
break;
case 4:
s.concat();
break;
case 5:
s.count();
break;
case 6:
s.findAndReplace();
break;
}
System.out.println("Do u want to Continue press 1 otherwise press 0");
c=Integer.parseInt(dis.readLine());
}
}
}


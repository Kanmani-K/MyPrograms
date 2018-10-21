public class HelloWorld
{ 	
	public native void hello();
	static
	{
		System.load("E://java and internet//HelloWorld//Debug//HelloWorld.dll");
	}
	public static void main(String args[])
	{
		HelloWorld obj=new HelloWorld();
		obj.hello();
	}
}
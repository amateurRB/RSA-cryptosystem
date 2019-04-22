import java.util.*;
import java.io.*;
import java.lang.Math;

class RSA1
{
	public static void main(String args[])
	{
		//String str1="";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a");
		int a=sc.nextInt();
		System.out.println("enter b");
		int b=sc.nextInt();
		System.out.println("enter message");
		int mess=sc.nextInt();
		int n=a*b;
		int e=0,d=0,x=0;
		//System.out.println(pubk);
		int y=(a-1)*(b-1);
		
		//e :public key
		for (int i=2;i<y;i++)
		{
			if(gcd(i,y)==1)
			{
				e=i;
				break;
			}
		}
		
		//d: private key
		for(int i=0;i<y;i++)
		{
		if(((i*e)%y)==1)
			{
				d=i;
				break;
			}
		}
		
		
		System.out.println(e);
		System.out.println(d);
		int cip=(int)Math.pow(mess,e)%n;
		System.out.println("Cipher "+cip);
		int plain=(int)Math.pow(cip,d)%n;
		System.out.println("Plain "+plain);

		
		
	}
	public static int gcd(int a , int b)
	{
		while(a!=0 && b!=0)
		{
			if(a>b)
				a=a-b;
			else
				b=b-a;
		}
		return a;
	}
}
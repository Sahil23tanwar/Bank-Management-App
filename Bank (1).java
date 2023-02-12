import java.util.*;
class Bank_Detail
{
	private int acno,amt;
	private String cnm;

	public void readInput()
	{
		Scanner S=new Scanner(System.in);
		acno=S.nextInt();
		cnm=S.next();
		amt=S.nextInt();
	}
	int showData(int an)
	{
		int t=0;
		if(an==acno)
		{
			System.out.println("Customer Name:= "+cnm);
			System.out.println("Amount:= "+amt);
			t=1;
		}
		return(t);
	}
	public int depositMoney(int an,int am)
	{
 		int t=0;
		if(an==acno)
		{
			amt=amt+am;
			System.out.println("Amount Deposit");
			t=1;
		}
		return(t);	
	}
	int withdrawMoney(int ann,int ammt)
	{
		int t=0;
		if(ann==acno)
		{
			if(amt>ammt)
			{
				amt=amt-ammt;
				System.out.println("withdraw Money Success");
			}
			else
			{
				System.out.println("Insufficient Balance");	
			}
			t=1;
		}
		return(t);		
	}
	void showResult()
	{
		System.out.println("Customer Name:= "+cnm);
		System.out.println("Amount:= "+amt);
		System.out.println("Acount number:= "+acno);		
	}

}
class Bank
{
	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		char choice;
		System.out.println("How many data to store");
		int size=S.nextInt();
		Bank_Detail B[]=new Bank_Detail[size];//declaration and instantiation in one line
		do
		{
		System.out.println("1. Add Record");
		System.out.println("2. Show Record");
		System.out.println("3. Deposit Money");
		System.out.println("4. Withdraw Money");
		System.out.println("5. Output Whole Data");
		System.out.println("Enter your choice to continue");
		int ch=S.nextInt();
		switch(ch)
		{
		case 1:
			for(int i=0;i<size;i++)
			{
				B[i]=new Bank_Detail();
				System.out.println("Enter Customer "+(i+1)+" (detail acno,Name, Balance)");
				B[i].readInput();				
			}
			break;
		case 2:
			System.out.println("Enter acount number:=");
			int an=S.nextInt();
			int i;
			for(i=0;i<size;i++)
			{
				if(B[i].showData(an)==1)
				{
					break;
				}
			}
			if(i==size)
			{
				System.out.println("Wrong Account Number");
			}
			break;
		case 3:
			System.out.println("Enter acount number:=");
			int ann=S.nextInt();
			System.out.println("Enter Amount:=");
			int ammt=S.nextInt();
			
			for(i=0;i<size;i++)
			{
				if(B[i].depositMoney(ann,ammt)==1)
				{
					break;
				}
			}
			if(i==size)
			{
				System.out.println("Wrong Account Number");
			}
			break;
		case 4:
			System.out.println("Enter acount number:=");
			ann=S.nextInt();
			System.out.println("Enter Amount:=");
			ammt=S.nextInt();
			
			for(i=0;i<size;i++)
			{
				if(B[i].withdrawMoney(ann,ammt)==1)
				{
					break;
				}
			}
			if(i==size)
			{
				System.out.println("Wrong Account Number");
			}
			break;
		case 5:
			for(i=0;i<size;i++)
			{
				B[i].showResult();
			}
		}
		System.out.println("Choice to continue:=");
		choice=S.next().charAt(0);
		}while(choice=='y');
	}
}
import java.util.*;
class Account
{
	int accno;
	String name;
	double balance;

	Account(int accno,String name,double balance)
	{
		this.accno=accno;
		this.name=name;
		this.balance=balance;
	}
}
class Bank
{
	public static void main(String[]args)
	{
		ArrayList <Account> lst=new ArrayList<>();
		Scanner sc=new Scanner(System.in);

		outer:
		while(true)
		{
		    System.out.println("\n===== Bank Management System =====");
			System.out.println("1. Add Accounts");
			System.out.println("2. Display All Accounts");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Delete Account");
		    System.out.println("6. Transfer Amount");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int op=sc.nextInt();

			switch(op)
			{

			case 1:
				System.out.print("Enter number of accounts to add: ");
				int n=sc.nextInt();

				while(n!=0)
				{
				    
					System.out.print("Enter Account Number: ");
					int accno=sc.nextInt();
            
					sc.nextLine();
					
					boolean duplicate=false;
					for(int i=0;i<lst.size();i++)
					{
					    if(accno==lst.get(i).accno)
					    {
					        duplicate=true;
					        break;
					    }
					}
					if(!duplicate)
					{
					System.out.print("Enter Account Holder Name: ");
					String name=sc.nextLine();

					System.out.print("Enter Initial Balance: ");
					double balance=sc.nextDouble();

					Account obj = new Account(accno,name,balance);
					lst.add(obj);

					System.out.println("Account created successfully.\n");
					n--;
					}
					else
					{
					    System.out.println("Account number already exists. Please try a different one.");
					}
				}
				
				break;

			case 2:
				if(lst.size()==0)
				{
					System.out.println("No accounts available.");
				}
				else
				{
					System.out.println("\n===== Account Details =====");
					for(int i=0; i<lst.size(); i++)
					{
						System.out.println("Account No: "+lst.get(i).accno+" | Name: "+lst.get(i).name+
						" | Balance: "+lst.get(i).balance);
					}
				}
				break;

			case 3:
				System.out.print("Enter account number to deposit: ");
				int accnum=sc.nextInt();

				int f=0;
				for(int i=0; i<lst.size(); i++)
				{
					if(accnum==lst.get(i).accno)
					{
						f=1;
						System.out.print("Enter amount to deposit: ");
						double d=sc.nextDouble();

						if(d>0)
						{
							lst.get(i).balance+=d;
							System.out.println("Amount deposited successfully!");
							System.out.println("Updated Balance: "+lst.get(i).balance);
							break;
						}
						else
						{
							System.out.println("Invalid amount. Please enter positive value.");
						}
					}
				}
				if(f==0)
				{
					System.out.println("Account not found.");
				}
				break;

			case 4:
				System.out.print("Enter account number to withdraw: ");
				int Accnum=sc.nextInt();

				int flag=0;
				for(int i=0; i<lst.size(); i++)
				{
					if(Accnum==lst.get(i).accno)
					{
						flag=1;
						System.out.print("Enter amount to withdraw: ");
						double amount=sc.nextDouble();

						if(amount>0 && lst.get(i).balance>=amount)
						{
							lst.get(i).balance-=amount;
							System.out.println("Withdrawal successful!");
							System.out.println("Updated Balance: "+lst.get(i).balance);
						}
						else if(amount<=0)
						{
							System.out.println("Invalid amount.");
						}
						else
						{
							System.out.println("Insufficient balance.");
						}
						
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("Account not found.");
				}
				break;

			case 5:
				System.out.print("Enter account number to delete: ");
				int Accnumber=sc.nextInt();

				int found=0;
				for(int i=0; i<lst.size(); i++)
				{
					if(Accnumber==lst.get(i).accno)
					{
						found=1;
						lst.remove(i);
						System.out.println("Account deleted successfully!");
						break;
					}
				}
				if(found==0)
				{
					System.out.println("Account not found.");
				}
				break;
				
			case 6:
			    
			    System.out.println("Enter Sender Account Number");
			    int senderno=sc.nextInt();
			    
			    System.out.println("Enter Receiver Account Number");
			    int receiverno=sc.nextInt();
			    
			    
			    
			     if(receiverno==senderno)
			    {
			         System.out.println("Cannot transfer to same account");
                     break;
			    }
			    
			    
			    int green=0;
			    int si=0;
			    for(int i=0;i<lst.size();i++)
			    {
			        if(senderno==lst.get(i).accno)
			        {
			            green=1;
			             si=i;
			             break;
			        }
			    }
			    
			    
			    int red=0;
			    int ri=0;
			    for(int i=0;i<lst.size();i++)
			    {
			        if(receiverno==lst.get(i).accno)
			        {
			            red=1;
			             ri=i;
			             break;
			        }
			    }
			   
			    if(green==1&&red==1)
			    {
			        System.out.print("Enter amount to transfer: ");
			        double money=sc.nextDouble();
			        
			        if(money>0&&lst.get(si).balance>=money)
			        {
			            lst.get(si).balance-=money;
			            lst.get(ri).balance+=money;
			            
			              System.out.println("Transfer Successful");
                          System.out.println("Sender Balance: "+lst.get(si).balance);
                          System.out.println("Receiver Balance: "+lst.get(ri).balance);
			        }
			        else if(money<=0)
			        {
			             System.out.println("Invalid amount");
			        }
			        else
			        {
			            System.out.println("Insufficient balance");
			        }
			       
			    }
			    else
                {
                     System.out.println("Sender or Receiver account not found");
                }
			    break;
			    
			case 7:
				System.out.println("Thank you for using Bank Management System!");
				break outer;
			}
		}
        sc.close();
	}
}
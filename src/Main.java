class ATM{
	synchronized public void checkBalance (String name){
		System.out.print(name+ " is checking");
		try {
			Thread.sleep(1000);
		}
		catch (Exception e)
		{}

			System.out.println("balance");
		}
	synchronized public void withDraw (String name,int amount)
	{
		System.out.print(name+" is withdrawing");
		try {
			Thread.sleep(1000);
		}

		catch (Exception e)
		{}
			System.out.println(amount);

	}
}
class Customer extends Thread {
	ATM atm;
	String name;
	int amount;
	Customer(String n, ATM a,int amt)
	{
		name=n;
		atm=a;
		amount=amt;

	}
	public void useATM()
	{
		atm.checkBalance(name);
		atm.withDraw(name,amount);
	}

	@Override
	public void run() {
		useATM();
	}
}
public class Main {
	public static void main(String[] args) {
		ATM atm=new ATM();
		Customer c1=new Customer("smith",atm,100);
		Customer c2=new Customer("john",atm,200);
		c1.start();
		c2.start();
	}
}
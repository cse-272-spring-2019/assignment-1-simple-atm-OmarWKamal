package project1;
import java.util.ArrayList;

public class Bankacc {
	long balance;
	withdraw withdrawal = new withdraw();
	int i = -1;
	ArrayList<String> history = new ArrayList<String>(); 
	public Bankacc() {
		this.balance = 0;
	}
	public void withdraw(String x)
	{
		i++;
		long g = valueOf(x);
		this.balance = balance - g;
		if(history.size() < 5) {
			history.add("Withdrawal of amount: " + g);
			//history.add(this.balance);
		}
		else {
			history.add("Withdrawal of amount: " + x);
			//history.add(this.balance);
		}
	}
	public void deposit(String y) {
		i++;
		long g = valueOf(y);
		this.balance = balance + g;
		if(history.size() < 5) {
			history.add("Deposition of amount: " + y);
			//history.add(i,this.balance);
		}
		else {
			history.add("Deposition of amount: " + y);
			//history.add(this.balance);
		}
	}

	public long getBalance() {
		//SAVING IN HISTORY IF BALANCE IS NOT EQUAL ZERO
		if(this.balance > 0) {
			i++;
			this.history.add("Balance Inquiry: " + this.balance);
		}
		return balance;
	}

	public void setBalance(long l) {
		this.balance = l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int getI() {
		return i;
	}
	public  Long valueOf(String text) {
		Long x = (long) 0;
		int j =-1;
		for(int i = text.length()-1; i >= 0; i--)
		{	
			j++;
			x = (long) (x + (text.charAt(i) - '0') * Math.pow(10, j));
		}
		return x;
	}

}

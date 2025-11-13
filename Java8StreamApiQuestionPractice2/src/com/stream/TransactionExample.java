package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//You have a list of transactions (id, amount). Sort them by amount descending, and then by transaction id ascending.

public class TransactionExample {
	
	int id ;
	double amount;
	
	
	public TransactionExample(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction[id=" + id + ", amount=" + amount + "]";
	}
	
}



class TransactionTest{
	public static void main(String[] args) {
		
		List<TransactionExample> trans = Arrays.asList(
				new TransactionExample(101, 50000),
				new TransactionExample(102, 60000),
				new TransactionExample(103, 40000),
				new TransactionExample(106,20000),
				new TransactionExample(104,300000));
		//You have a list of transactions (id, amount). Sort them by amount descending, and then by transaction id ascending.
		trans.stream().sorted(Comparator.comparingDouble(TransactionExample::getAmount).reversed()
				.thenComparingInt(TransactionExample::getId))
				.forEach(System.out::println);
		
		//Any Transaction Above 1 Lakh
		boolean transaction = trans.stream().filter(x->x.getAmount()>100000).findAny().isPresent();
		System.out.println("transaction greater than 1lakh is  "+ transaction);

	}

	
}
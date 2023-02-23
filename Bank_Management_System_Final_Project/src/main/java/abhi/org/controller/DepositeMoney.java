package abhi.org.controller;


import java.util.Scanner;

import abhi.org.dto.BankAccount;
import abhi.org.service.CustomerService;


public class DepositeMoney {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your  Customer  id :");
		int CustomerId = sc.nextInt();
		System.out.println("Enter your bank id :");
		int bankId = sc.nextInt();
		System.out.println("Enter your Amount to deposite :");
		double amount = sc.nextDouble();
		
		if(amount>0) {
		CustomerService customerService = new CustomerService();
		BankAccount bankAccount = customerService.depositAmount(CustomerId, bankId, amount);
		if (bankAccount != null) {
			System.out.println("transacation succesfull");
		} else {
			System.out.println("transacation failed");
		}
		}else {
			System.out.println("invalid Amount");
		}
	}
}

package abhi.org.controller;


import java.util.Scanner;

import abhi.org.dto.BankAccount;
import abhi.org.service.CustomerService;


public class SaveBankAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your  Customer  id :");
		int id = sc.nextInt();

		System.out.println("Enter your Intinal Balance :");
		double amount = sc.nextDouble();
		if (amount > 999) {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setBalance(amount);

			CustomerService customerService = new CustomerService();
			customerService.saveBankAccount(bankAccount, id);
		} else {
			System.out.println("Opening Balance must be more 1000 ");
		}

	}
}

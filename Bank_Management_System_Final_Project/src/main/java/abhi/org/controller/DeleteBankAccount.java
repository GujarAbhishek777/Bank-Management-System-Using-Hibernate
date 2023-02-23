package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.CustomerService;


public class DeleteBankAccount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	    System.out.println("Enter Your BankAccountId :");
	    int id=sc.nextInt();
		CustomerService customerService=new CustomerService();
		customerService.deleteBankAccount(id);
	}
}

package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.CustomerService;


public class GetBankAccountDetailsOfCustomerById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Customer id :");
		int customerId= sc.nextInt();
		
		CustomerService customerService= new CustomerService();
		customerService.getBankAccount(customerId);
		
	}
}
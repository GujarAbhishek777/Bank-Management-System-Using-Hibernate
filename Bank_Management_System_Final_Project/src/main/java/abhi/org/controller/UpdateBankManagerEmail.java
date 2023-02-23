package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.BankManagerService;


public class UpdateBankManagerEmail {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id");
		int id= sc.nextInt();
		System.out.println("Enter your Email");
		String email=sc.next();
		BankManagerService bankManagerService = new BankManagerService();
	    bankManagerService.updateBankManagerEmail(id,email);
		
	}
}

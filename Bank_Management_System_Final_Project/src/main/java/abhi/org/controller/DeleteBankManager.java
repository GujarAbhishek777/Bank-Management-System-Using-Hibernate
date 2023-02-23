package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.BankManagerService;


public class DeleteBankManager {

	public static void main(String[] args) {
      
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id :");
		int id=sc.nextInt();
		
		BankManagerService bankManagerService = new BankManagerService();
        bankManagerService.deleteBankManagerById(id);
		
	}
}

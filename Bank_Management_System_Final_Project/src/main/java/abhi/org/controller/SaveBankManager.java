package abhi.org.controller;


import java.util.Scanner;

import abhi.org.dto.BankManager;
import abhi.org.service.BankManagerService;


public class SaveBankManager {

public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter your name :");
	String name=sc.next();
	System.out.println("Enter your email :");
	String email=sc.next();
	System.out.println("Enter your Password :");
	String password=sc.next();
	System.out.println("defalut Manager Status is unapproved");	
	
		BankManager bankManager = new BankManager(); 
		bankManager.setName(name);
		bankManager.setEmail(email);
		bankManager.setPassword(password);
		
		
		BankManagerService bankManagerService = new BankManagerService();
		BankManager bankManager2 = bankManagerService.saveBankManager(bankManager);
		if (bankManager2 != null) {
			System.out.println("BankManager Inserted");
		} else {
            System.out.println("Not Inserted");
		}
	}
}
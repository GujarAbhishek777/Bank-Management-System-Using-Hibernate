package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.BankManagerService;


public class ApprovedAllCustomers {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Manager id :");
		int id= sc.nextInt();
		BankManagerService bankManagerService= new BankManagerService();
		bankManagerService.approvedAllCustomers(id);
	}
}

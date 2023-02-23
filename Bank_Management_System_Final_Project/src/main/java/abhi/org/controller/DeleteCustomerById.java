package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.CustomerService;


public class DeleteCustomerById {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id :");
		int id=sc.nextInt();
		CustomerService customerService=new CustomerService();
		customerService.deleteCustomer(id);
	}
}

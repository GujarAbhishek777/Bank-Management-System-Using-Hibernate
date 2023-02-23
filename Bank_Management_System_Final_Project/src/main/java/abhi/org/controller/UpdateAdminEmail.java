package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.AdminService;


public class UpdateAdminEmail {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id :");
		int id=sc.nextInt();
		System.out.println("Enter your New Email :");
		String email=sc.next();
		
		AdminService adminService=new AdminService();
		adminService.updateAdminEmailById(id, email);

	}
}

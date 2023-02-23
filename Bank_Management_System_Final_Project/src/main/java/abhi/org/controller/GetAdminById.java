package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.AdminService;


public class GetAdminById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id :");
		int id=sc.nextInt();
		
		
		AdminService adminService=new AdminService();
		adminService.getAdminById(id);
	}
}
package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.AdminService;


public class ApprovedBankManager {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Admin id :");
		int adminid=sc.nextInt();
		
		System.out.println("Enter your bankManager id :");
		int bankManagerid=sc.nextInt();
		
		AdminService adminService= new AdminService();
		adminService.approvedBankManger(bankManagerid, adminid);
		
		
	}
}

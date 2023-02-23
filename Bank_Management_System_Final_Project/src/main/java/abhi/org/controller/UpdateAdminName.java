package abhi.org.controller;


import java.util.Scanner;

import abhi.org.service.AdminService;


public class UpdateAdminName {
public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	System.out.println("Enter your id :");
	int id=sc.nextInt();
	System.out.println("Enter your New Name :");
	String name=sc.next();
	
	AdminService adminService=new AdminService();
	adminService.updateAdminNameById(id, name);

}
}
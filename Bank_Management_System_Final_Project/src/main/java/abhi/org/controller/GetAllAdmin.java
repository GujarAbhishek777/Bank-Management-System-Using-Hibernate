package abhi.org.controller;


import java.util.List;

import abhi.org.dto.Admin;
import abhi.org.service.AdminService;


public class GetAllAdmin {
 public static void main(String[] args) {
	
	 AdminService adminService = new AdminService();
	 
	 
	 List<Admin> admin2 = adminService.getAdminAll();
}
}

package abhi.org.controller;


import java.util.List;

import abhi.org.service.CustomerService;


public class GetAllCustomers {

	public static void main(String[] args) {
		CustomerService customerService= new CustomerService();
		customerService.getAllCustomers();
	}
}

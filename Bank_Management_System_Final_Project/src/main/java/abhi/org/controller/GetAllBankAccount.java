package abhi.org.controller;

import abhi.org.service.CustomerService;

public class GetAllBankAccount {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	customerService.getAllBankAccounts();
}
}

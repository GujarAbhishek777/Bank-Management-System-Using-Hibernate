package abhi.org.service;


import java.util.List;

import abhi.org.dao.CustomerDao;
import abhi.org.dto.BankAccount;
import abhi.org.dto.Customers;
import abhi.org.dto.Statement;



public class CustomerService {
CustomerDao customerDao=new CustomerDao();
	
	// save customers
		public Customers saveCustomers(Customers customers) {
			return customerDao.saveCustomers(customers);
		}
	
	// delete customers	
		public Customers deleteCustomer(int id) {
			return customerDao.deleteCustomer(id);
		}
		
	
	// update customers name by id
		public Customers updateCustomersNameById(int id,String name) {
			return customerDao.updateCustomersNameById(id,name);
		}
		
		
	// update customers dob by id
	public Customers updateCustomersDobById(int id,String dob) {
		return customerDao.updateCustomersDobById(id,dob);
	}
	
	

	// update customers gender by id
	public Customers updateCustomersGenderById(int id,String gender) {
		return customerDao.updateCustomersGenderById(id,gender);
	}
	
	// get customers by Id
	public Customers getCustomersById(int id) {
		return customerDao.getCustomersById(id);
	}
	
	//Get all customers 
		public List<Customers> getAllCustomers(){
			return customerDao.getAllCustomers();
		}
	
		public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
			return customerDao.saveBankAccount(bankAccount, customerId);
		}

		public BankAccount deleteBankAccount(int id) {
			return customerDao.deleteBankAccount(id);
		}

		public BankAccount getBankAccount(int id) {
			return customerDao.getBankAccount(id);
		}

		public List<BankAccount> getAllBankAccounts() {
			return customerDao.getAllBankAccounts();
		}
		
		public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
			return customerDao.depositAmount(customerId, bankAccountId, amount);
		}

		public BankAccount debiteAmount(int customerId, int bankAccountId, double amount) {
			return customerDao.debiteAmount(customerId, bankAccountId, amount);
		}

		public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
			return customerDao.transferAmount(customerId, creditorId, depositorId, amount);
		}
		
		public List<Statement> bankAccountStatement(int bankAccountId) {
			return customerDao.bankAccountStatement(bankAccountId);
		}
	
	
}

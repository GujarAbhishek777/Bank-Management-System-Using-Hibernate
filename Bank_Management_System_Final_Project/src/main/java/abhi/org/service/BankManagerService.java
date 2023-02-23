package abhi.org.service;


import java.util.List;

import abhi.org.dao.BankManagerDao;
import abhi.org.dto.BankManager;
import abhi.org.dto.Customers;


public class BankManagerService {

	public BankManager saveBankManager(BankManager bankManager) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.saveBankManager(bankManager);
	}
	
	public BankManager updateBankManagerName(int id,String name) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.updateBankManagerName(id,name);
	}
	
	public BankManager updateBankManagerEmail(int id,String email) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.updateBankManagerEmail(id,email);
	}
	
	public BankManager updateBankManagerPassword(int id,String password) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.updateBankManagerPassword(id,password);
	}
	
	
	public BankManager deleteBankManagerById(int id) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.deleteBankManagerById(id);
	}
	
	public BankManager getBankManagerById(int id) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.getBankManagerById(id);
	}
	
	public List<BankManager> getAllBankManager() {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.getAllBankManager();
	}
	//approved customers
	public List<Customers> approvedAllCustomers(int id){
		BankManagerDao bankManagerDao = new BankManagerDao();

		return bankManagerDao.approvedAllCustomers(id);
	}
	
	public Customers approvedCustomer(int customerId, int bankManagerId) {
		BankManagerDao bankManagerDao = new BankManagerDao();
		return bankManagerDao.approvedCustomer(customerId, bankManagerId);

	}
	
// delete Customers by bankmanager
	public Customers deleteCustomersById(int managerId, int CustomerId) {
		BankManagerDao bankManagerDao = new BankManagerDao();

		return bankManagerDao.deleteCustomersById(managerId, CustomerId);
	}
	
}

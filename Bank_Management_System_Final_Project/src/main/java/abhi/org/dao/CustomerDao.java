package abhi.org.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import abhi.org.dto.BankAccount;
import abhi.org.dto.Customers;
import abhi.org.dto.Statement;


public class CustomerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save customers
	public Customers saveCustomers(Customers customers) {

		String sql = "Select c from Customers c";
		Query query = entityManager.createQuery(sql);
		List<Customers> customer = query.getResultList();
		for (Customers c : customer) {
			if (c.getAdharno() == customers.getAdharno()) {
				System.out.println("Customer already exist");
				return null;
			}
		}
		customers.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customers);
		entityTransaction.commit();
		System.out.println("Customers save");
		return customers;
	}
	
	//delete customer
		public Customers deleteCustomer(int id) {
			Customers customers = entityManager.find(Customers.class, id);
			if (customers != null) {
				entityTransaction.begin();
				entityManager.remove(customers);
				entityTransaction.commit();
				System.out.println("Customer deleted successfully");
			} else {
				System.out.println("Customer not exist");
			}
			return customers;
		}

	// update customers name by id
	public Customers updateCustomersNameById(int id, String name) {
		Customers customers = entityManager.find(Customers.class, id);
		if (customers != null) {
			customers.setName(name);
			entityTransaction.begin();
			entityManager.merge(customers);
			entityTransaction.commit();
			System.out.println("Customers Name Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customers;
	}

	// update customers dob by id
	public Customers updateCustomersDobById(int id, String dob) {
		Customers customers = entityManager.find(Customers.class, id);
		if (customers != null) {
			customers.setDob(dob);
			entityTransaction.begin();
			entityManager.merge(customers);
			entityTransaction.commit();
			System.out.println("Customers Date of birth Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customers;
	}

	// update customers gender by id
	public Customers updateCustomersGenderById(int id, String gender) {
		Customers customers = entityManager.find(Customers.class, id);
		if (customers != null) {
			customers.setGender(gender);
			entityTransaction.begin();
			entityManager.merge(customers);
			entityTransaction.commit();
			System.out.println("Customers Gender Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customers;
	}

	// get customers by Id
	public Customers getCustomersById(int id) {

	Customers customers= entityManager.find(Customers.class, id);
	if(customers!=null) {
		System.out.println("=================================================================================================");
		System.out.print(customers.getId()+"\t");
		System.out.print(customers.getName()+"\t");
		System.out.print(customers.getGender()+"\t");
		System.out.print(customers.getDob()+"\t");
		System.out.print(customers.getAdharno()+"\t");
		System.out.print(customers.getStatus()+"\t");
	}else {
		System.out.println("Customer not exist");
	}
	return customers;
	}

	// Get all customers
	public List<Customers> getAllCustomers() {

		String sql = "Select c from Customers c";

		Query query = entityManager.createQuery(sql);
		List<Customers> c = query.getResultList();

		for (Customers customers : c) {
			System.out.println("============================================================");
			System.out.println(customers.getId());
			System.out.println(customers.getName());
			System.out.println(customers.getGender());
			System.out.println(customers.getDob());
			System.out.println(customers.getAdharno());
			System.out.println(customers.getStatus());

		}
		return c;
	}

	// Save bank Accoount
	public BankAccount saveBankAccount(BankAccount bankAccount,int CustomerId ) {
		List<BankAccount> b=getAllBankAccounts();
		for(BankAccount bankAccount1:b) {
			if(bankAccount1.getCustomers().getId()==CustomerId) {
				System.out.println("You Allready have an Account");
				return null;
			}
		}

		Customers customers = entityManager.find(Customers.class, CustomerId);
		if (customers != null) {
			if (customers.getStatus().equals("Approved")) {
				bankAccount.setCustomers(customers);
				bankAccount.setName(customers.getName());
				bankAccount.setBankname("SBI bank");
				bankAccount.setAccno(49221000+customers.getId());
				bankAccount.setIfsc("JSP0JAVA");
				entityTransaction.begin();
				entityManager.persist(bankAccount);
				entityTransaction.commit();
				System.out.println("BankAccount Sussesfully Added");
			} else {
				System.out.println("You are not approved Customers");
			}
		} else {
			System.out.println("customers not found");
		}
		return bankAccount;
	}
	
	//delete bankaccount
	public BankAccount deleteBankAccount(int id) {
		BankAccount bankAccount = entityManager.find(BankAccount.class, id);
		if (bankAccount != null) {
			entityTransaction.begin();
			entityManager.remove(bankAccount);
			entityTransaction.commit();
			System.out.println("BankAccount deleted successfully");
		} else {
			System.out.println("BankAccount not exist");
		}
		return bankAccount;
	}
	
	// get particular bankAccount details
		public BankAccount getBankAccount(int id) {
			BankAccount bankAccount = entityManager.find(BankAccount.class, id);
			if (bankAccount != null) {
				System.out.println("===========================================================================================================");
				System.out.print(bankAccount.getId()+"\t");
				System.out.print(bankAccount.getName()+"\t");
				System.out.print(bankAccount.getBankname()+"\t");
				System.out.print(bankAccount.getAccno()+"\t");
				System.out.print(bankAccount.getIfsc()+"\t");
				System.out.print(bankAccount.getBalance()+"\t");
			} else {
				System.out.println("BankAccount not exist");
			}
			return bankAccount;
		}

		// get all bankAccounts details
		public List<BankAccount> getAllBankAccounts() {
			String sql = "Select b from BankAccount b";
			Query query = entityManager.createQuery(sql);
			List<BankAccount> bankAccount = query.getResultList();
			for (BankAccount b : bankAccount) {
				System.out.println("=====================");
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getBankname());
				System.out.println(b.getAccno());
				System.out.println(b.getIfsc());
				System.out.println(b.getBalance());
			}
			return bankAccount;
		}


		// deposit amount
		public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (amount > 0) {
					b.setBalance(b.getBalance() + amount);
					statement.setBid(bankAccountId);
					statement.setDetails("Deposited : Rs." + amount + " to your Account no:" + b.getAccno());

					entityTransaction.begin();
					entityManager.merge(b);
					entityManager.persist(statement);
					entityTransaction.commit();
					System.out.println("Amount deposited successfully");
				} else {
					System.out.println("Invalid amount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}

		
		Statement statement=new Statement();
		
		// debited amount
		public BankAccount debiteAmount(int customerId, int bankAccountId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (b.getCustomers().getId() == customerId) {
					if (amount < b.getBalance() && amount > 0) {
						b.setBalance(b.getBalance() - amount);
						statement.setBid(bankAccountId);
						statement.setDetails("Debited : Rs." + amount + " from your Account no:" + b.getAccno());

						entityTransaction.begin();
						entityManager.merge(b);
						entityManager.persist(statement);
						entityTransaction.commit();
						System.out.println("Amount Debited successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}

		// transfer amount
		public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b1 = entityManager.find(BankAccount.class, creditorId);
			BankAccount b2 = entityManager.find(BankAccount.class, depositorId);
			if (c.getStatus().equals("Approved")) {
				if (b1.getCustomers().getId() == customerId) {
					if (amount > 0 && b1.getBalance() > amount) {
						b1.setBalance(b1.getBalance() - amount);
						statement.setBid(creditorId);
						statement.setDetails("Credited  : Rs." + amount + " from your Account no:" + b1.getAccno());

						b2.setBalance(b2.getBalance() + amount);
						Statement statement1 = new Statement();
						statement1.setBid(depositorId);
						statement1.setDetails("Deposited : Rs." + amount + " by Account no :" + b1.getAccno());

						entityTransaction.begin();
						entityManager.merge(b1);
						entityManager.merge(b2);
						entityManager.persist(statement);
						entityManager.persist(statement1);
						entityTransaction.commit();
						System.out.println("Amount transfer successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b1;
		}

		// statement of bankAccounts
		public List<Statement> bankAccountStatement(int bankAccountId) {
			String sql = "Select s from Statement s";
			Query query = entityManager.createQuery(sql);

			List<Statement> s = query.getResultList();
			System.out.println("=================================================================================================");
			System.out.println("Statement of BankAccount Id : "+bankAccountId);
			for (Statement res : s) {
				if (bankAccountId == res.getBid()) {
					System.out.println(res.getDetails());
				}
			}
			return s;
		}


}

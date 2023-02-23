package abhi.org.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import abhi.org.dto.BankManager;
import abhi.org.dto.Customers;


public class BankManagerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//save bankmanager
	public BankManager saveBankManager(BankManager bankManager) {
		
		bankManager.setStatus("Unapproved");
		
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		
		return bankManager;
	}
	
	//update bankManager name
    public BankManager updateBankManagerName(int id,String name) {
		
    	BankManager bankManager1 = entityManager.find(BankManager.class, id);
    	if(bankManager1!=null) {
    		bankManager1.setName(name);
    		entityTransaction.begin();
    		entityManager.merge(bankManager1);
    		entityTransaction.commit();
    		System.out.println("BankManager Name Upadated");
    	}else {
    		System.out.println("BankManager Not Found");
    	}
		return bankManager1;
	}
    
	//update bankManager email
     public BankManager updateBankManagerEmail(int id,String email) {
		
    	BankManager bankManager1 = entityManager.find(BankManager.class, id);
    	if(bankManager1!=null) {
    		bankManager1.setEmail(email);
    		entityTransaction.begin();
    		entityManager.merge(bankManager1);
    		entityTransaction.commit();
    		System.out.println("BankManager Email Upadated");
    	}else {
    		System.out.println("BankManager Not Found");
    	}
		return bankManager1;
	 }
     
 	//update bankManager password
     public BankManager updateBankManagerPassword(int id,String password) {
	
	    BankManager bankManager1 = entityManager.find(BankManager.class, id);
	    if(bankManager1!=null) {
		bankManager1.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(bankManager1);
		entityTransaction.commit();
		System.out.println("BankManager Password Upadated");
	   }else {
		System.out.println("BankManager Not Found");
	   }
	   return bankManager1;
     }
    
 	//delete bankManager 

    public BankManager deleteBankManagerById(int id) {
		
    	BankManager bankManager1 = entityManager.find(BankManager.class, id);
    	if(bankManager1!=null) {
    			
		entityTransaction.begin();
		entityManager.remove(bankManager1);
		entityTransaction.commit();
		System.out.println(bankManager1.getName()+"BankManager Deleted Succesfully ");
    	}else {
    		System.out.println("BankManager Not Found");

    	}
		return bankManager1;
	}
    
	//get particular bankManager details
    public BankManager getBankManagerById(int id) {
		
    	BankManager bankManager1 = entityManager.find(BankManager.class, id);
    	
    	if (bankManager1 != null) {
			System.out.println(bankManager1.getId());
			System.out.println(bankManager1.getName());
			System.out.println(bankManager1.getEmail());
			System.out.println(bankManager1.getPassword());
			System.out.println(bankManager1.getStatus());
		} else {
			System.out.println("No Object BankManager Found");
		}		
		
		return bankManager1;
	}
    
	//get all bankManagers details
    public List<BankManager> getAllBankManager() {
    	
    	String sql = "Select b From BankManager b";
    	Query query = entityManager.createQuery(sql);
    	
    	List<BankManager> bankManagers = query.getResultList();
    	
    	for (BankManager b : bankManagers) {
    		System.out.println("==============");
    		System.out.println(b.getId());
			System.out.println(b.getName());
			System.out.println(b.getEmail());
			System.out.println(b.getPassword());
			System.out.println(b.getStatus());
		}
    	
    	return bankManagers;
    }
    
 // delete customers by own Manger
 	public Customers deleteCustomersById(int bankmanagerId, int CustomerId) {
 		BankManager bankmanager = entityManager.find(BankManager.class, bankmanagerId);
 		Customers customers = entityManager.find(Customers.class, CustomerId);
 		if (bankmanager != null) {
 			if (customers != null) {
 				if(customers.getBankManager().getId()==bankmanagerId) {
 				entityTransaction.begin();
 				entityManager.remove(customers);
 				entityTransaction.commit();
 				System.out.println(customers.getName() + " deleted Succesfully");
 				}else {
 					System.out.println(customers.getName()+" is not your Customers");
 				}
 			} else {
 				System.out.println("Customers not Found");
 			}
 		} else {
 			System.out.println("invalid Manager Credential");
 		}
 		return customers;
 	}
 	

 	// approved customers
 	public List<Customers> approvedAllCustomers(int id) {
 		BankManager bankmanager = entityManager.find(BankManager.class, id);
 		List<Customers> customers = null;
 		if (bankmanager != null) {
 			if (bankmanager.getStatus().equals("Approved")) {
 				String sql = "select c from Customers c";
 				Query query = entityManager.createQuery(sql);

 				customers = query.getResultList();
 				for (Customers c : customers) {
 					if (c.getStatus().equals("Unapproved")) {
 						c.setStatus("Approved");
 						c.setBankManager(bankmanager);
 						entityTransaction.begin();
 						entityManager.merge(c);
 						entityTransaction.commit();
 						System.out.println(c.getName() + " is approved");
 					}
 				}
 			} else {
 				System.out.println("you are not approved manager");
 			}
 		} else {
 			System.out.println("Manager " + id + " does not exist");
 		}
 		return customers;
 	}



	//approve particular customer
	public Customers approvedCustomer(int customerId, int bankManagerId) {
		Customers customers=entityManager.find(Customers.class, customerId);
		BankManager bankManager=entityManager.find(BankManager.class, bankManagerId);
		if(bankManager.getStatus().equals("Approved")) {
		if(customers.getStatus().equals("Unapproved")) {
			customers.setStatus("Approved");
			customers.setBankManager(bankManager);
			entityTransaction.begin();
			entityManager.merge(customers);
			entityTransaction.commit();
			System.out.println("Approved Successfully");
		}else {
			System.out.println("Customer already approved");
		}
		}else {
			System.out.println("Bankmanager is not Approved");
		}
		return customers;
	}
}
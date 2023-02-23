package abhi.org.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import abhi.org.dto.Admin;
import abhi.org.dto.BankManager;



public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//save admin
	public Admin saveAdmin(Admin admin) {
		if(admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			
			System.out.println("Admin inserted");
		}
		else {
			System.out.println("Not inserted");
		}
		
		return admin;
	}
	
    // update Admin name
	public Admin updateAdminNameById(int id,String name) {
		
		Admin admin1 =entityManager.find(Admin.class, id);
		
		if(admin1!=null) {
			admin1.setName(name);
			entityTransaction.begin();
			entityManager.merge(admin1);
			entityTransaction.commit();
			System.out.println("Admin Name Updated");
		}else {
			System.out.println("Admin Not Found");
		}
		
		return admin1;
	}
	
	// update Admin email
    public Admin updateAdminEmailById(int id,String email) {
		
		Admin admin1 =entityManager.find(Admin.class, id);
		
		if(admin1!=null) {
			admin1.setEmail(email);
			entityTransaction.begin();
			entityManager.merge(admin1);
			entityTransaction.commit();
			System.out.println("Admin Gmail Updated");
		}else {
			System.out.println("Admin Not Found");
		}
		
		return admin1;
	}

    //update Admin password
    public Admin updateAdminPasswordById(int id,String password) {
	
	Admin admin1 =entityManager.find(Admin.class, id);
	
	if(admin1!=null) {
		admin1.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(admin1);
		entityTransaction.commit();
		System.out.println("Admin Password Updated");
	}else {
		System.out.println("Admin Not Found");
	}
	
	    return admin1;
    }
	
    //delete Admin
    public Admin deleteAdminById(int id) {
		
		Admin admin1 =entityManager.find(Admin.class, id);
		
		if(admin1!=null) {
		entityTransaction.begin();
		entityManager.remove(admin1);;
		entityTransaction.commit();
		System.out.println(admin1.getName()+" Deleted Succesfully");
		}
		else {
			System.out.println("Admin Not Found");
		}
		return admin1;
	}
    
    //Get admin
    public Admin getAdminById(int id) {
		
		Admin admin1 =entityManager.find(Admin.class, id);
		
		if(admin1!=null) {
			System.out.println(admin1.getId());
			System.out.println(admin1.getName());
			System.out.println(admin1.getEmail());
			System.out.println(admin1.getPassword());
		}
		else {
			System.out.println("No Object Admin found");
		}
		
		
		return admin1;
	}
    
    //Get all admin
    public List<Admin> getAdminAll() {
		
    	String sql = "Select a From Admin a";
    	
    	Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		
	    for (Admin a : admins) {
			System.out.println("==============");
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getEmail());
			System.out.println(a.getPassword());
			
		}
		
		return admins;
	}
    
    // Approved All Manager
    public List<BankManager> approvedAllBankManager(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		List<BankManager> bankManager=null;
		if (admin != null) {

			BankManagerDao 	bankManagerDao = new 	BankManagerDao();
			bankManager = bankManagerDao.getAllBankManager();
			for (BankManager bmanager : bankManager) {
				if (bmanager.getStatus().equals("Unapproved")) {
					bmanager.setStatus("Approved");
					bmanager.setAdmin(admin);
					System.out.println("manager approved");
					entityTransaction.begin();
					entityManager.merge(bmanager);
					entityTransaction.commit();
				}
			}
		}else {
			System.out.println("no such Admin id");
		}
		return bankManager;
	}
    
    
 // approved particular Manager
 	public BankManager approvedBankManger(int bankManagerId, int adminId) {
 		BankManager bankmanager = entityManager.find(BankManager.class, bankManagerId);
 		Admin admin=entityManager.find(Admin.class, adminId);
 		if(admin!=null) {
 			if (bankmanager.getStatus().equals("Unapproved")) {
 			bankmanager.setStatus("Approved");
 			bankmanager.setAdmin(admin);
 			entityTransaction.begin();
 			entityManager.merge(bankmanager);
 			entityTransaction.commit();
 			System.out.println("Approved Successfully");
 			} else {
 				System.out.println("BankManager already approved");
 			}
 		}
 		else {
 			System.out.println("Admin not exist");
 		}
 		return bankmanager;
 	}

}

    
    
	
    
	


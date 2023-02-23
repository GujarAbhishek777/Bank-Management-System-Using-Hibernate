package abhi.org.service;


import java.util.List;

import abhi.org.dao.AdminDao;
import abhi.org.dto.Admin;
import abhi.org.dto.BankManager;



public class AdminService {

  public Admin saveAdmin(Admin admin) {
	AdminDao adminDao = new AdminDao();
	return adminDao.saveAdmin(admin);
  }

  public Admin deleteAdminById(int id) {
	AdminDao adminDao = new AdminDao();
	return adminDao.deleteAdminById(id);
  }

  public Admin updateAdminNameById(int id,String name) {
	AdminDao adminDao = new AdminDao();
	return adminDao.updateAdminNameById(id,name);
  }

  public Admin updateAdminEmailById(int id,String email) {
		AdminDao adminDao = new AdminDao();
		return adminDao.updateAdminEmailById(id,email);
  }
  
  public Admin updateAdminPasswordById(int id,String password) {
		AdminDao adminDao = new AdminDao();
		return adminDao.updateAdminPasswordById(id,password);
  }
  
  public Admin getAdminById(int id) {
	AdminDao adminDao = new AdminDao();
	return adminDao.getAdminById(id);
  }

  public List<Admin> getAdminAll() {
	AdminDao adminDao = new AdminDao();
	return adminDao.getAdminAll();
  }
  public List<BankManager> approvedAllManager(int id)
	{
		AdminDao adminDao = new AdminDao();
		return adminDao.approvedAllBankManager(id);
	}
  
	public BankManager approvedBankManger(int bankManagerId, int adminId) {
		AdminDao adminDao= new AdminDao();
		return adminDao.approvedBankManger(bankManagerId, adminId);
	}
	
}

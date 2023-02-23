package abhi.org.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Email;
	private String Password;
	
	@OneToMany(mappedBy = "admin")
	private List<BankManager> bankManager;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public List<BankManager> getBankManager() {
		return bankManager;
	}
	public void setBankManager(List<BankManager> bankManager) {
		this.bankManager = bankManager;
	}
}

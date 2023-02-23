package abhi.org.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BankManager {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Email;
	private String Password;
	private String Status;
	
	@ManyToOne
	@JoinColumn
	private Admin admin;
	
	@OneToMany(mappedBy = "bankManager",cascade = CascadeType.ALL)
	private List<Customers> customers;
	
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
}
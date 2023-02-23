package abhi.org.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String dob;
	private long adharno;
	private String status;
	
	@ManyToOne
	@JoinColumn
	private BankManager bankManager;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getAdharno() {
		return adharno;
	}
	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BankManager getBankManager() {
		return bankManager;
	}
	public void setBankManager(BankManager bankManager) {
		this.bankManager = bankManager;
	}
	
}

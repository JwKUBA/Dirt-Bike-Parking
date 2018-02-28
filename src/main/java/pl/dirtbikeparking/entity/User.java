package pl.dirtbikeparking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name="user")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotBlank
	@Column(unique = true)
	@Size(min = 3, max = 30)
	private String username;
	
	@NotBlank
	@Email
	@Column(unique = true)
	@Size(min = 5, max = 30)
	private String email;
	
	@NotBlank
	private String password;
	
	
	
	@NotBlank
	@Size(min = 3, max = 20)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 20)
	private String surname;
	
	@NotNull
	@Pattern(regexp="(^$|[0-9]{9})")
	private String telNumber;
	
	
	@NotNull
	@Size(min = 3, max = 20)
	private String location;
	
	@OneToMany(mappedBy = "user",  cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	private List <Notice> notice;
	
	private boolean isAdmin;
	
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Notice> getNotice() {
		return notice;
	}

	public void setNotice(List<Notice> notice) {
		this.notice = notice;
	}
	
	
	
}

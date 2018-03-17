package pl.dirtbikeparking.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="notice")

public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//	private ToObserve toObserver;


	@ManyToOne(cascade = CascadeType.MERGE)
	private User createdBy;
	
	@NotEmpty
	@Size(max= 15)
	private String brand;
	
	//@NotEmpty
	//@Size(min=1970, max=2050)
	private String year;
	
	@NotNull
	private int mileage;
	
	@NotNull
	@Min(49)
	@Max(700)
	private int capacity;
	
	@Max(100000)
	@NotNull
	private int price;
	
	@NotEmpty
	@Size (max = 1000)
	private String description;
	
	private String engineType;
	
	
	private Date created;
	
	
	private String fileUrl;
	
	@ManyToOne
	private User user;
	
	
	public Notice() {
		super();
		this.created = new Date();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}



	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public String getFileUrl() {
		return fileUrl;
	}


	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public String getEngineType() {
		return engineType;
	}


	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	


	public User getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	

	
	
	
	
	
	
	
	
	
	
	
}

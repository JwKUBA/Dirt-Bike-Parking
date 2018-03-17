package pl.dirtbikeparking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "to_observe")
public class ToObserve {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int test;
	
	@ManyToOne
	private User toObserve;

	@OneToOne
	private Notice notice;
	
//	@OneToMany(mappedBy = "toObserver",  cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//	private List <Notice> elo =new ArrayList<>();

	

	

	public User getToObserve() {
		return toObserve;
	}

	public void setToObserve(User toObserve) {
		this.toObserve = toObserve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	

	public ToObserve(int id, int test) {
		super();
		this.id = id;
		this.test = test;
	}
	
	public ToObserve() {
		super();
		
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	

}

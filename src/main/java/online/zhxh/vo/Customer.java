package online.zhxh.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "t_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(View.Base.class)
	private Long id;
	@JsonView(View.Base.class)
	private String firstName;
	@JsonView(View.Base.class)
	private String lastName;
	@JsonView(View.OneToMany.class)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Post> post;

	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

}
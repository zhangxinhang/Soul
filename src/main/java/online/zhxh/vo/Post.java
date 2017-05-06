package online.zhxh.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "bd_post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(View.Base.class)
	private Integer id;
	@JsonView(View.Base.class)
	private String title;
	@JsonView(View.Base.class)
	private String raw_url;
	@JsonView(View.Base.class)
	private String buy_url;
	@JsonView(View.Base.class)
	private Date submit_time;

	@JsonView(View.ManyToOne.class)
	@ManyToOne
	private Customer user;

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRaw_url() {
		return raw_url;
	}

	public void setRaw_url(String raw_url) {
		this.raw_url = raw_url;
	}

	public String getBuy_url() {
		return buy_url;
	}

	public void setBuy_url(String buy_url) {
		this.buy_url = buy_url;
	}

	public Date getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}

}

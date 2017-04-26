package online.zhxh.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bd_post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String raw_url;
	private String buy_url;
	private Date submit_time;

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

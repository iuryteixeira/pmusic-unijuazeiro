package pmusic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Music {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;

	private Double time;

	public Music() {

	}

	public Music(String name, Double time) {
		super();
		this.name = name;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

}

package pmusic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_music")
	@SequenceGenerator(initialValue = 10, allocationSize = 1, name = "gen_music", sequenceName = "seq_music")
	private Integer id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

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

	@PrePersist
	private void setup() {
		this.createdAt = new Date();
	}

}

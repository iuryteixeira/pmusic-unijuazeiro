package pmusic.model.music;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pmusic.model.MyEntity;
import pmusic.model.style.Style;

@Entity
public class Music implements MyEntity {

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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "music_detail")
	private MusicDetail detail;

	@ManyToOne(fetch = FetchType.EAGER)
	private Style style;

	public Music() {

	}

	public Music(String name, Double time) {
		super();
		this.name = name;
		this.time = time;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public MusicDetail getDetail() {
		return detail;
	}

	public void setDetail(MusicDetail detail) {
		this.detail = detail;
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

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@PrePersist
	private void setup() {
		this.createdAt = new Date();
	}

}

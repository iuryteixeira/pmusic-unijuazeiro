package pmusic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MusicDetail {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_md", sequenceName = "seq_md")
	@GeneratedValue(generator = "gen_md", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String url;

	public MusicDetail() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

package pmusic.model.style;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import pmusic.model.MyEntity;

@Entity
public class Style implements MyEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;

	public Style() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

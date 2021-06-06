package pmusic.service;

import pmusic.dao.MusicDAO;
import pmusic.model.music.Music;
import pmusic.util.PMusicException;

public class MusicService {

	private MusicDAO musicDAO = new MusicDAO();

	public void create(Music music) {
		if (music.getName() == null || music.getName().isBlank()) {
			throw new PMusicException(2001, "Nome não preenchido!");
		}
		if (music.getTime() < 1.0) {
			throw new PMusicException(2002, "Tempo mínimo não atingido!");
		}
		musicDAO.persist(music);
	}

}

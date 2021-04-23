package pmusic;

import pmusic.dao.MusicDAO;
import pmusic.dao.util.ConnectionFactory;
import pmusic.model.Music;

public class PMusicApplication {

	public static void main(String[] args) {

		MusicDAO musicDAO = new MusicDAO();

		for (Music m : musicDAO.all()) {
			System.out.println(m.getName());
		}

		ConnectionFactory.close();
	}

}

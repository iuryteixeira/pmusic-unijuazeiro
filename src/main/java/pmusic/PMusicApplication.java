package pmusic;

import java.util.UUID;

import pmusic.dao.MusicDAO;
import pmusic.dao.StyleDAO;
import pmusic.dao.util.ConnectionFactory;
import pmusic.model.Music;
import pmusic.model.MusicDetail;
import pmusic.model.Style;
import pmusic.service.MusicService;
import pmusic.util.PMusicException;

public class PMusicApplication {

	public static void main(String[] args) {

		MusicService musicService = new MusicService();
		MusicDAO musicDAO = new MusicDAO();
		StyleDAO styleDAO = new StyleDAO();
		try {
			Style styleStored = styleDAO.findById(UUID.fromString("1978f0dc-be18-42f3-b490-72533f6bbdb4"));

			MusicDetail detail = new MusicDetail();
			detail.setUrl("https://stream.pmusic.io/music2");

			Music music = new Music("Musica 2", 4.56);
			music.setStyle(styleStored);
			music.setDetail(detail);

			musicService.create(music);
			for (Music m : musicDAO.all()) {
				System.out.println(m.getName());
				System.out.println(m.getCreatedAt());
				if (m.getDetail() != null) {
					System.out.println(m.getDetail().getUrl());
				}
				if (m.getStyle() != null) {
					System.out.println(m.getStyle().getName());
				}
			}

		} catch (

		PMusicException e) {
			System.out.println(e.getCode() + " - " + e.getMessage());
		}

		ConnectionFactory.close();
	}

}

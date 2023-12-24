package wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	List<WiseSaying> wiseSayings = new ArrayList<>();
	private int lastId = 0;

	public int write(String content, String author) {
		int id = lastId + 1;

		wiseSayings.add(new WiseSaying(id, content, author));

		lastId++;

		return id;
	}

	public List<WiseSaying> list() {
		return wiseSayings;
	}

	public void remove(int id) {
		wiseSayings.remove(wiseSayings.get(id - 1));
	}

	public void modify(int id, String content, String author) {
		wiseSayings.get(id - 1).setContent(content);
		wiseSayings.get(id - 1).setAuthor(author);
	}

	public List<WiseSaying> findAll() {
		return wiseSayings;
	}

}

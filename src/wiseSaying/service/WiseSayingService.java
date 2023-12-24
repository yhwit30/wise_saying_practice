package wiseSaying.service;

import java.util.List;

import wiseSaying.entity.WiseSaying;
import wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

	public int write(String content, String author) {
		int id = wiseSayingRepository.write(content, author);
		return id;
	}

	public List<WiseSaying> list() {
		List<WiseSaying> wiseSayings = wiseSayingRepository.list();
		return wiseSayings;
	}

	public void remove(int id) {
		wiseSayingRepository.remove(id);
	}

	public void modify(int id, String content, String author) {
		wiseSayingRepository.modify(id, content, author);

	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.findAll();
	}

}

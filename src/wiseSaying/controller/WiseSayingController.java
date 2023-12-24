package wiseSaying.controller;

import java.util.List;

import wise.saying.practice.Container;
import wise.saying.practice.Rq;
import wiseSaying.entity.WiseSaying;
import wiseSaying.service.WiseSayingService;

public class WiseSayingController {
	WiseSayingService wiseSayingService = new WiseSayingService();

	public void write() {

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author);

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);

	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		if (wiseSayings.size() == 0) {
			System.out.println("등록된 명언이 없습니다.");
		}

		System.out.println("번호 / 작가 / 명언");
		System.out.println("===============");
		for (int i = wiseSayings.size() - 1; i >= 0; i--) {
			WiseSaying ws = wiseSayings.get(i);
			System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
		}
	}

	public void remove(Rq rq) {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.printf("id(정수)를 제대로 입력해주세요.\n", id);
			return;
		}

		if (wiseSayings.get(id - 1) == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}
		wiseSayingService.remove(id);
		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
	}

	public void modify(Rq rq) {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.printf("id(정수)를 제대로 입력해주세요.\n", id);
			return;
		}
		if (wiseSayings.get(id - 1) == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		System.out.println("기존 명언" + wiseSayings.get(id - 1).getContent());
		System.out.print("새 명언 : ");
		String content = Container.getScanner().nextLine().trim();

		System.out.println("기존 작가" + wiseSayings.get(id - 1).getAuthor());
		System.out.print("새 작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(id, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}
}
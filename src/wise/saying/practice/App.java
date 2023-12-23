package wise.saying.practice;

import wiseSaying.controller.WiseSayingController;
import wiseSaying.system.controller.SystemController;

public class App {

	private byte systemRun = 1;
	WiseSayingController wiseSayingController = new WiseSayingController();

	public void run() {

		System.out.println("===앱 실행===");
		while (systemRun == 1) {
			System.out.print("명령어 )");
			String cmd = Container.getScanner().nextLine().trim();
			Rq rq = new Rq(cmd);

			switch (rq.getActionCode()) {
			case "종료":
				SystemController.end();
				systemRun = 0;
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다.");

			}

		}
	}
}

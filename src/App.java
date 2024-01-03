import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	private Scanner sc;

	public App(Scanner sc) {
		this.sc = sc;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();
		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String content = sc.nextLine().trim();
				System.out.print("작가 : ");
				String author = sc.nextLine().trim();

				WiseSaying wiseSaying = new WiseSaying(id, content, author);
				wiseSayings.add(wiseSaying);
				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++;
			} else if (cmd.equals("목록")) {
				System.out.println(" 번호   / 작가   / 명언   ");
				System.out.println("=".repeat(30));

				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					WiseSaying ws = wiseSayings.get(i);
					System.out.printf(" %d   / %s   / %s \n", ws.getId(), ws.getAuthor(), ws.getContent());

				}
			} else if (cmd.equals("수정")) {
				System.out.print("수정할 번호 입력 : ");
				long modifyId = sc.nextLong();
				sc.nextLine();

				for (WiseSaying ws : wiseSayings) {
					if (ws.getId() == modifyId) {
						System.out.printf("기존 명언 : %s \n", ws.getContent());
						System.out.printf("새 명언 : ");
						String content = sc.nextLine().trim();
						System.out.printf("기존 작가 : %s \n", ws.getAuthor());
						System.out.printf("새 작가 : ");
						String author = sc.nextLine().trim();

						ws.setAuthor(author);
						ws.setContent(content);
						System.out.println(modifyId + "번 명언이 수정되었습니다.");
					}

				}		
			} else if (cmd.equals("삭제")) {
				System.out.print("삭제할 번호 입력 : ");
				long removeId = sc.nextLong();
				sc.nextLine();

				for (WiseSaying ws : wiseSayings) {
					if (ws.getId() == removeId) {
						wiseSayings.remove(ws);
						System.out.println(removeId + "번 명언이 삭제되었습니다.");
					}
				}
				

			} else {
				System.out.println("올바른 명령어가 아닙니다.");
			}

		}
	}

}

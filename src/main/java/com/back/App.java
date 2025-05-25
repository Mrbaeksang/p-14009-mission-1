package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final WiseSayingController controller = new WiseSayingController(scanner);

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine().trim();

            if (command.equals("등록")) {
                controller.register();
            } else if (command.equals("목록")) {
                controller.showList();
            } else if (command.startsWith("삭제")) {
                controller.remove(command);
            } else if (command.startsWith("수정")) {
                controller.modify(command);
            } else if (command.equals("종료")) {
                break;
            } else {
                System.out.println("올바르지 않은 명령어입니다.");
            }
        }

        scanner.close();
    }
}
package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService service;


    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.service = new WiseSayingService();
    }

    public void register() {
        System.out.println("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.println("작가 : ");
        String author = scanner.nextLine().trim();
        WiseSaying wiseSaying = service.register(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", (wiseSaying.getId());
    }

    public void showList() {
        service.showList();
    }

    public void remove(String command) {
        try {
            String idStr = command.substring("삭제?id=".length()).trim();
            int id = Integer.parseInt(idStr);

            WiseSaying wiseSaying = service.findById(id);

            if (wiseSaying == null) {
                System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                return;
            }

            service.remove(id);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

        } catch (NumberFormatException e) {
            System.out.println("id는 숫자여야 합니다. " + e.getMessage());

        }
    }

    public void modify(String command) {
        try {
            String idStr = command.substring("수정?id=".length()).trim();
            int id = Integer.parseInt(idStr);

            WiseSaying wiseSaying = service.findById(id);

            if (wiseSaying == null) {
                System.out.printf("%d번 명언은 존재하지 않습니다.", id);
            }

            System.out.printf("명언(기존) : %s\n명언 : ", wiseSaying.getContent());
            String content = scanner.nextLine().trim();

            System.out.printf("작가(기존) : %s\n작가 : ", wiseSaying.getAuthor());
            String author = scanner.nextLine().trim();

            service.modify(id, content, author);
            System.out.printf("%d번 명언이 수정되었습니다.", id);
        } catch (NumberFormatException e) {
            System.out.println("id는 숫자여야 합니다. " + e.getMessage());
        }
    }
}

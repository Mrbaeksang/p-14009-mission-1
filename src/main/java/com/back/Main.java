package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();
        int id = 1;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                quotes.add(new Quote(id, content, author));

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                id++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote quote = quotes.get(i);
                    System.out.printf("%d / %s / %s\n", quote.id, quote.author, quote.content);
                }
            } else if (command.startsWith("삭제?id=")) {
                try {
                    int deleteId = Integer.parseInt(command.substring("삭제?id=".length()));
                    
                    boolean found = false;
                    for (int i = 0; i < quotes.size(); i++) {
                        if (quotes.get(i).id == deleteId) {
                            quotes.remove(i);
                            System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID 형식이 올바르지 않습니다. 예: 삭제?id=1");
                }
            } else if (command.startsWith("수정?id=")) {
                try {
                    int modifyId = Integer.parseInt(command.substring("수정?id=".length()));

                    boolean modified = false;
                    for (Quote quote : quotes) {
                        if(quote.id == modifyId) {
                            System.out.println("명언(기존) : " + quote.content);
                            System.out.print("명언 : ");
                            quote.content = sc.nextLine();

                            System.out.println("작가(기존) : " + quote.author);
                            System.out.print("작가 : ");
                            quote.author = sc.nextLine();

                            System.out.println("%d번 명언이 수정되었습니다.".formatted(modifyId));
                            modified = true;
                            break;
                        }
                    }

                    if(!modified){
                        System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyId));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID 형식이 올바르지 않습니다. 예: 수정?id=1");
                }
            } else if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("올바른 명령어가 아닙니다.");
            }
        }
        sc.close();
    }
}

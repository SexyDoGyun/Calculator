package lv3;

import java.util.Scanner;


// 부가 기능 실행 클래스
public class Command {

    public static boolean process(Options option, Scanner sc) {
        System.out.println("더 계산할건가요?");
        System.out.println("기능 : [exit : 종료, show : 결과 확인, del : 결과 삭제, big : 특정 값 보다 큰 값 조회]");

        // order에 대문자, 소문자, 빈 값이 들어올 수 있으므로 받아올 때 toLowerCase().trim()를 통해 소문자로 변환시키고, 양쪽에 빈 값을 없앤다.
        String order = sc.nextLine().toLowerCase().trim();
        if (order.equals("exit")) {
            System.out.println("계산기를 종료합니다. 안녕히 가세요");
            return true;
        } else if (order.equals("show")) {
            option.showResult();
        } else if (order.equals("del")) {
            option.deleteOldest();
        } else if (order.equals("big")) {
            System.out.print("비교하고 싶은 값을 입력해주세요: ");
            double compareNum = sc.nextDouble();
            option.showBigger(compareNum);
            sc.nextLine();
        } else {
            System.out.println("올바른 명령어가 아닙니다. 다시 입력해주세요.");
        }
        return false;
    }
}

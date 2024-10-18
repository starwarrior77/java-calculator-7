package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
    String delimiter = ",|:";  // 기본 구분자

    // 이후 코드는 다음 커밋에서 추가
    String[] tokens = input.split(delimiter);
    int sum = 0;
    for (String token : tokens) {
        // 이후 코드는 다음 커밋에서 추가
    }
    return sum;
    }
}
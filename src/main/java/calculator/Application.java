package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        // 구분자를 기준으로 문자열을 분리하고 숫자로 변환
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            int num = parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}

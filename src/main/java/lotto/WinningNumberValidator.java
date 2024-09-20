package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidator {
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private static final int LOTTO_SIZE = 6;
    public static List<Integer> parseAndValidateWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.size() != LOTTO_SIZE || !numbers.stream().allMatch(WinningNumberValidator::isValidNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 오류");
        }

        return numbers;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int number = Integer.parseInt(input);
        if (!isValidNumber(number) || winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 오류");
        }
        return number;
    }

    private static boolean isValidNumber(int number) {
        return number >= MIN_NUM && number <= MAX_NUM;
    }
}

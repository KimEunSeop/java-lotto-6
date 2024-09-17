package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 6자리가 아님");
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[Error]번호 중복");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}

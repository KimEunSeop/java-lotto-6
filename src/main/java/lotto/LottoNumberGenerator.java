package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private static final int COUNT = 6;

    private LottoNumberGenerator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}

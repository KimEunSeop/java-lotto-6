package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private List<Lotto> lottoList;

    public LottoCreator(int count) {
        createLotto(count);
    }

    private void createLotto(int count) {
        lottoList = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(LottoNumberGenerator.generateLottoNumber()))
                .collect(Collectors.toList());

    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void printLottoList() {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }
}

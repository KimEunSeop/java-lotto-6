package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    public int[] resultArray = {0, 0, 0, 0, 0};
    private int attempts;

    public LottoResult(List<Lotto> lottoList) {
        attempts = lottoList.size();
        checkLotto(lottoList);
    }

    private void checkLotto(List<Lotto> lottoList) {
        WinningNumberInput winningNumberInput = new WinningNumberInput();

        for (Lotto lotto : lottoList) {
            List<Integer> common = new ArrayList<>(winningNumberInput.getWinningNumbers());
            common.retainAll(lotto.getNumbers());

            checkCondition(common.size(), lotto.getNumbers(), winningNumberInput);
        }
    }

    private void checkCondition(int commonSize, List<Integer> lottoNumbers, WinningNumberInput winningNumberInput) {
        if (commonSize == 6) {
            resultArray[4]++;
            return;
        }
        if (commonSize == 5 && lottoNumbers.contains(winningNumberInput.getBonusNumber())) {
            resultArray[3]++;
            return;
        }
        if (commonSize >= 3 && commonSize <= 5) {
            resultArray[commonSize - 3]++;
            return;
        }
    }

    private double CalculateReturn() {
        int allResult = resultArray[0] * 5000 + resultArray[1] * 50000 + resultArray[2] * 1500000 + resultArray[3] * 30000000 + resultArray[4] * 200000000;
        double result = (double) allResult / (attempts * 10);

        // 소수점 둘째자리에서 반올림
        return Math.round(result * 100) / 100.0;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치(5000원) - " + resultArray[0] + "개");
        System.out.println("4개 일치(50,000원) - " + resultArray[1] + "개");
        System.out.println("5개 일치(1,500,000원) - " + resultArray[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultArray[3] + "개");
        System.out.println("6개 일치(2,000,000,000원) - " + resultArray[4] + "개");
        System.out.println("총 수익률은 " + CalculateReturn() + "%입니다.");
    }

}

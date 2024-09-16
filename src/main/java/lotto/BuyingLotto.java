package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyingLotto {
    static int lottoCount;

    public BuyingLotto() {
        buyLotto();
    }

    private void buyLotto() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int money = Integer.parseInt(input);
                validateInput(money);
                lottoCount = money / 1000;
                System.out.println(lottoCount + "개를 구매했습니다.");
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 1000원 단위여야 합니다. 다시 입력해 주세요.");
            }
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void validateInput(int money) {
        if (money % 1000 == 0) return;
        throw new IllegalArgumentException();
    }

}

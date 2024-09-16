package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinningNumberInput {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumberInput() {
        setWinningNumber();
    }

    private void setWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningNumbers = WinningNumberValidator.parseAndValidateWinningNumbers(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        bonusNumber = WinningNumberValidator.validateBonusNumber(bonusInput, winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

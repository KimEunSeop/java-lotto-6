package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyingLotto buyingLotto = new BuyingLotto();
        LottoCreator lottoCreator = new LottoCreator(buyingLotto.getLottoCount());
        lottoCreator.printLottoList();
        LottoResult lottoResult = new LottoResult(lottoCreator.getLottoList());
        lottoResult.printResult();
    }
}

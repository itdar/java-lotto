package lotto;

import lotto.application.CreateShffledLottoNumbers;
import lotto.application.PlayLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.util.LottoNumberRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    PlayLotto playLotto = new PlayLotto();
    @Test
    @DisplayName("금액에 따른 로또 생성")
    void lottoCountTest(){
        int cash = 14000;
        List<Lotto> lottos = playLotto.createLotto(cash);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 범위 static list")
    void lottoNumberRangeTest(){
        List<Integer> lottoNumberRange = LottoNumberRange.getLottoNumberRange();
        List<Integer> lottoNumberRange1 = LottoNumberRange.getLottoNumberRange();
        assertThat(lottoNumberRange).isEqualTo(lottoNumberRange1);
        assertThat(lottoNumberRange.size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또 생성")
    void createLottoTest(){
        Lotto lotto = new Lotto(new CreateShffledLottoNumbers());
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호 로또 생성")
    void createWinningLottoTest(){
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);
        Lotto winningLotto = new Lotto(winningLottoNumbers);

        assertThat(winningLotto.getLottoNumbers()).contains(1,2,3,4,5,6);
    }
}

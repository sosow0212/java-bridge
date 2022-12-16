package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final List<String> testBridge = List.of("U", "U", "U");

    @Test
    @DisplayName("유저의 정답이 맞는지 확인")
    public void isUserAnswerCorrectTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(testBridge);
        String direction = "U";

        // when
        boolean result = bridgeGame.isUserAnswerCorrect(direction);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 성공 테스트")
    public void gameWinTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(testBridge);

        // when
        bridgeGame.move();
        bridgeGame.move();
        bridgeGame.move();

        // then
        assertThat(bridgeGame.isGameWin()).isEqualTo(true);
    }
}

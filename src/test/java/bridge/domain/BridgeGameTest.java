package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final List<String> testBridge = List.of("U", "U", "U");

    @Test
    @DisplayName("이동 실패 테스트")
    public void moveFailTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(testBridge);

        // when
        bridgeGame.moveFail();

        // then
        assertThat(bridgeGame.isGameDone()).isEqualTo(true);
    }
}

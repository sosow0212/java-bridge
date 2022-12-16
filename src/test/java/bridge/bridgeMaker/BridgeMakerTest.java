package bridge.bridgeMaker;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGeneratorTest());

    @Test
    @DisplayName("다리 생성 테스트 (1 : U만 나옴)")
    public void makeBridgeTest() {
        // given
        List<String> result = List.of("U", "U", "U");
        int size = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge).isEqualTo(result);
    }
}

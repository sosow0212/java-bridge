package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int nowIndex;
    private int tryCount;
    private boolean isGameDone;
    private boolean isGameWin;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        nowIndex = 0;
        tryCount = 0;
        isGameDone = false;
        isGameWin = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        if (nowIndex == bridge.size()) {
            // 게임이 끝난 경우
            doGameWin();
            return;
        }
        // 게임이 끝나지 않은 경우
        nowIndex++;
    }

    public void doGameWin() {
        doGameDone();
        isGameWin = true;
    }

    public void handleGame(String direction) {
        if (isUserAnswerCorrect(direction)) {
            move();
        }
        if (!isUserAnswerCorrect(direction)) {
            moveFail();
        }
    }

    public void moveFail() {
        doGameDone();
    }

    private void doGameDone() {
        isGameDone = true;
    }

    public boolean isUserAnswerCorrect(String direction) {
        return direction.equals(bridge.get(nowIndex));
    }

    public boolean isGameDone() {
        return isGameDone;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        nowIndex = 0;
        tryCount += 1;
        isGameDone = false;
    }
}

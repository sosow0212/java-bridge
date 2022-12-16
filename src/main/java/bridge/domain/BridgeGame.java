package bridge.domain;

import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private int nowIndex;
    private int tryCount;
    private boolean isGameDone;
    private boolean isGameWin;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        nowIndex = 0;
        tryCount = 1;
        isGameDone = false;
    }

    public void move() {
        nowIndex++;
        if (nowIndex == bridge.size()) {
            doGameWin();
        }
    }

    private void doGameWin() {
        isGameDone = true;
        isGameWin = true;
    }

    public void moveFail() {
        isGameDone = true;
        isGameWin = false;
    }

    public boolean isUserAnswerCorrect(String direction) {
        return direction.equals(bridge.get(nowIndex));
    }

    public boolean isGameWin() {
        return isGameWin && isGameDone;
    }

    public boolean isGameDone() {
        return isGameDone;
    }

    public void retry() {
        nowIndex = 0;
        tryCount += 1;
        isGameDone = false;
        isGameWin = false;
    }

    public int getTryCount() {
        return tryCount;
    }
}

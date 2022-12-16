package bridge.view;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String ERROR = "[ERROR] ";
    private static StringBuilder up = new StringBuilder();
    private static StringBuilder down = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String direction, boolean isCorrect) {
        handlePrintMap(direction, isCorrect);
        System.out.println("[ " + up.toString() + " ]");
        System.out.println("[ " + down.toString() + " ]");
    }

    public void handlePrintMap(String direction, boolean isCorrect) {
        if (up.toString().isEmpty() && down.toString().isEmpty()) {
            fillInMapAtFirst(direction, isCorrect);
            return;
        }
        fillInMapAtAfter(direction, isCorrect);
    }

    public void fillInMapAtFirst(String direction, boolean isCorrect) {
        if (direction.equals("U")) {
            up.append(getMark(isCorrect));
            down.append(" ");
        }
        if (direction.equals("D")) {
            up.append(" ");
            down.append(getMark(isCorrect));
        }
    }

    public void fillInMapAtAfter(String direction, boolean isCorrect) {
        if (direction.equals("U")) {
            up.append(" | " + getMark(isCorrect));
            down.append(" |  ");
        }
        if (direction.equals("D")) {
            up.append(" |  ");
            down.append(" | " + getMark(isCorrect));
        }
    }

    public String getMark(boolean isCorrect) {
        if (isCorrect) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("\n게임 성공 여부: " + isWin(bridgeGame.isGameWin()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    public String isWin(boolean isWin) {
        if (isWin) {
            return "성공";
        }
        return "실패";
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printRequestOfBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printRequestOfMovingDirection() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestOfAfterGameStatus() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}

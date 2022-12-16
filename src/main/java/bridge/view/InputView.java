package bridge.view;

import static bridge.view.OutputView.printError;

import bridge.exception.InputException;
import bridge.util.InputParser;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputException inputException = new InputException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            inputException.validateBridgeSize(input);
            return inputParser.parsingBridgeSize(input);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String input = Console.readLine();
            inputException.validateDirection(input);
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String input = Console.readLine();
            inputException.validateCommand(input);
            return input;
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
            return readGameCommand();
        }
    }
}

package bridge.exception;

import java.util.List;

public class InputException {
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;
    private final static List<String> VALID_DIRECTION_CASE = List.of("U", "D");
    private final static List<String> VALID_COMMAND_CASE = List.of("R", "Q");
    private final static String ONLY_CONTAINS_NUMBER_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final static String NOT_VALID_DIRECTION_MESSAGE = "방향은 U, D 입력만 가능합니다.";
    private final static String NOT_VALID_COMMAND_MESSAGE = "입력은 R, Q만 가능합니다.";

    public void validateBridgeSize(String input) {
        checkBridgeSizeOnlyContainsNumbers(input);
        checkIsBridgeSizeValidLength(input);
    }

    public void validateDirection(String input) {
        checkIsCorrectValueOfDirection(input);
    }

    public void validateCommand(String input) {
        checkIsCorrectValueOfCommand(input);
    }

    private void checkIsCorrectValueOfCommand(String input) {
        if(!VALID_COMMAND_CASE.contains(input)) {
            throw new IllegalArgumentException(NOT_VALID_COMMAND_MESSAGE);
        }
    }

    private void checkIsCorrectValueOfDirection(String input) {
        if(!VALID_DIRECTION_CASE.contains(input)) {
            throw new IllegalArgumentException(NOT_VALID_DIRECTION_MESSAGE);
        }
    }

    private void checkBridgeSizeOnlyContainsNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ONLY_CONTAINS_NUMBER_MESSAGE);
            }
        }
    }

    private void checkIsBridgeSizeValidLength(String input) {
        int size = Integer.valueOf(input);
        if (!(size >= MIN_SIZE && size <= MAX_SIZE)) {
            throw new IllegalArgumentException(ONLY_CONTAINS_NUMBER_MESSAGE);
        }
    }
}

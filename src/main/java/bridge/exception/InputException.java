package bridge.exception;

import java.util.List;

public class InputException {
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;
    private final static List<String> INPUT_CASE = List.of("U", "D");
    private final static String ONLY_CONTAINS_NUMBER_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public void validateBridgeSize(String input) {
        checkBridgeSizeOnlyContainsNumbers(input);
        checkIsBridgeSizeValidLength(input);
    }

    public void validateDirection(String input) {

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
        if (!(size >= MIN_SIZE && size <= 20)) {
            throw new IllegalArgumentException(ONLY_CONTAINS_NUMBER_MESSAGE);
        }
    }
}

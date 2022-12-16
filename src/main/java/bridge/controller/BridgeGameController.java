package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStart();
        BridgeGame bridgeGame = new BridgeGame(makeBridge(requestBridgeSize()));
        startGame(bridgeGame);
    }

    public void startGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isGameDone()) {
            String direction = requestDirection();
            processGame(bridgeGame, direction, bridgeGame.isUserAnswerCorrect(direction));
        }
        outputView.printResult(bridgeGame);
    }

    public void processGame(BridgeGame bridgeGame, String direction, boolean isCorrect) {
        if (isCorrect) {
            bridgeGame.move();
            outputView.printMap(direction, true);
        }
        if (!isCorrect) {
            outputView.printMap(direction, false);
            handleFailCase(bridgeGame);
        }
    }

    public void handleFailCase(BridgeGame bridgeGame) {
        String command = requestAfterGameStatus();
        if (command.equals("R")) {
            bridgeGame.retry();
            outputView.resetMap();
        }
        if (command.equals("Q")) {
            bridgeGame.moveFail();
        }
    }

    public List<String> makeBridge(int size) {
        return bridgeMaker.makeBridge(size);
    }

    private String requestAfterGameStatus() {
        outputView.printRequestOfAfterGameStatus();
        return inputView.readGameCommand();
    }

    private String requestDirection() {
        outputView.printRequestOfMovingDirection();
        return inputView.readMoving();
    }

    private int requestBridgeSize() {
        outputView.printRequestOfBridgeSize();
        return inputView.readBridgeSize();
    }
}

# 기능 구현 목록

---

## 순서 흐름

- 다리의 길이 입력받기
- 이동할 칸 선택 U, D
  - 실패한 경우
    - 재시작
    - 종료
  - 성공한 경우
    - 총 시도한 횟수 출력

## 패키지별 기능 구현

- Controller
  - BridgeController
    - 다리 건너기의 전반적인 흐름을 담당한다.

- Domain
  - BridgeGame
    - 다리에 대한 전반적인 정보를 저장하고, 행위를 책임진다.

- View
  - InputView
    - 입력을 담당한다.
  - OutputView
    - 출력을 담당한다.

- Exception
  - InputException
    - 입력에 대한 예외를 진행한다.

- BridgeMaker
  - BridgeNumberGenerator를 이용해 다리를 만든다.

## 구현 예상

- 도메인은 주어진 BridgeGame 하나만을 사용한다.
- 처음에 다리 길이를 입력받고, 다리를 만들고 이를통해 BridgeGame을 만든다.
- 행위에 대한 모든 것을 BridgeGame 도메인에서 처리하고 게임을 진행한다.

- 맵 출력에 대해서는 OutputView를 통해서 진행한다.

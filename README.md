# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
### Model
1. Car 클래스 구현 
- Car 이름과 현재 위치를 저장

2. Cars 일급 컬렉션 구현
- List 형태로 저장
- void addNewCar 함수로 전달받은 파라미터를 받고 
- void updateNewCar 함수로 매 턴마다 각 car에 값을 업데이트해서 넣어준다. Random 함수를 이용해서 처리
- 최대값인 차량을 뽑아서 출력해주는 함수 String getWinner()
  - 최대값인 숫자를 찾아서 출력해주는 int getMax()
  - 동일한 숫자를 location으로 가지는 Car의 이름을 출력하는 String getMxCarName()

3. randoms로 뽑은 숫자가 3 이하인 값이면 0을 리턴하고 그 이상이면 1을 리턴해주는 int checkPossibleToMove()

4. 모든 차들의 위치를 수정해주는 void updateCars()

5. Controller를 통해서 호출을 받으면 cars에서 차량들의 결과를 문자열로 출력해주는 String makeSentece()
   - 각 차량별로 현재 진행 상황을 출력해주는 cars 일급 컬렉션의 String printResult()
6. 최종 승자를 String으로 출력해주는 getWinner()

### View
1. 경주할 자동차 이름을 받아주는 함수 void receiveCarName()
2. 경주할 횟수를 받아주는 함수 void receiveTry()
   - 경주할 횟수가 숫자가 아닌 다른 숫자인지 확인해주는 boolean validateIsDigit()
4. 경주 결과를 출력해주는 void printResult()
5. 오류를 출력해주는 함수 void printError()

### Controller
1. 함수 파라미터로 String을 받으면 ,단위로 split해서 Model에 업데이트 요청
2. split한 함수의 이름이 다섯자 이하인지 확인해주는 함수 boolean validateNameLength
3. 주어진 횟수만큼 Model의 updateCars를 수행해주는 함수 runGame()
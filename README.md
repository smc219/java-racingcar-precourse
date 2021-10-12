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
- void resetCars 함수를 사용해서 완전 초기화해준다.

3. Controller를 통해서 호출을 받으면  cars에서 차량들의 결과를 컨트롤러로 전달해주는 함수 Cars sendResult

### View
1. 경주할 자동차 이름을 받아주는 함수 void receiveCarName()
2. 경주할 횟수를 받아주는 함수 void receiveTry()
3. 경주 결과를 출력해주는 void printResult()

### Controller
1. 함수 파라미터로 String을 받으면 ,단위로 split해서 Model에 업데이트 요청
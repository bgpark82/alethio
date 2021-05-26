# Alethio 사전과제

## Summary
고객이 음식 혹은 옷을 주문하는 프로젝트

## Goal
1. 주문
    - 저장 시, contactEmail, contactName, mobille은 좌우 공백은 Trim해서 저장
    - 주문 정보는 음식, 옷 ID를 포함
    - id가 음식 테이블 혹은 옷 테이블에 없으면 에러 반환
2. 아이템
    - 음식, 옷 테이블에 ID 레코드 값의 재고가 1 줄어든다
    - 재고가 10개 미만으로 줄어들면 입고 요청 레코드를 DB에 기록
    - 재고가 0인 경우 재고 없음 에러를 응답으로 반환
3. 입고 요청
    - 입고 요청은 암호화된 키값을 벤더사와 주고 받는다
        - 아마돈 : 아이템 이름 **뒤** 123
        - 쿠망 : 아이템 이름 **앞** 123
    - 실제 입고 요청 기능은 구현하지 않는다
    - 벤더 별로 요청하는 아이템이 다르다
        - 아마돈 : 음식
        - 쿠망 : 옷

## Install
```
mvnw package
java -jar ./target/service-0.0.1-SNAPSHOT.jar
```

## Documentation
```
http://localhost:8080/docs/index.html
```

## Test
```
mvnw test
```

## Acceptance Test Scenario
```
Feature: 주문 관련 기능

  Scenario: 음식을 주문한다
    Given 음식이 생성되어 있다
    When 음식을 주문한다
    Then 재고가 1 감소한다 

  Scenario: 옷을 주문한다
    Given 옷이 생성되어 있다
    When 옷을 주문한다
    Then 재고가 1 감소한다 

  Scenario: 음식 주문 시, 음식이 존재하지 않으면 에러를 발생시킨다
    Given 음식이 생성되어 있다
    When 음식을 주문한다
    Then 에러를 발생한다

  Scenario: 음식 주문 시, 10개 미만이 남으면 재고 요청한다
    Given 음식이 생성되어 있다
    When 음식을 주문한다
    Then 아마돈 재고 요청이 저장된다
    Then 재고가 1 감소한다 
    
  Scenario: 옷 주문 시, 10개 미만이 남으면 재고 요청한다
    Given 옷이 생성되어 있다
    When 옷을 주문한다
    Then 쿠망 재고 요청이 저장된다
    Then 재고가 1 감소한다 
```

## Convention
- class : Pascal case
- variable : Camel case
- package : Kebab case

## Directory Structure
```
src
├── main
│   └── domain
│       └── order
│           ├── application
│           ├── domain
│           ├── dto
│           └── ui
└── test
    └── domain
        └── order
            ├── acceptance
            ├── documentation
            ├── application
            ├── domain
            ├── step
            └── ui
```

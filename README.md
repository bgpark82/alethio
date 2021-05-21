# Alethio 사전과제

## Summary
고객이 음식 혹은 옷을 주문하는 프로젝트

## Install
```
./mvnw package
java -jar ./target/service-0.0.1-SNAPSHOT.jar
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
            ├── application
            ├── domain
            ├── step
            └── ui
```

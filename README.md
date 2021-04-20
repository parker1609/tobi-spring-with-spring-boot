# 토비의 스프링 3.1 with spring boot
토비의 스프링 3.1 책의 예제를 Spring Boot와 같은 현재 사용하고 있는 환경에 맞게 작성해본다.


## 환경
- Spring Boot 2.3.3 (Spring 5.2.8)
- Java8
- H2 Database (not memory)
- JUnit5
- Lombok


## 차이점
- Spring 3.1 -> Spring 5.2.8 + Spring boot 2.3.3
  - Spring Boot Starter Dependency 사용
- MySQL -> H2
- JUnit4 -> JUnit5
- Lombok 라이브러리 사용
- 익명 클래스 -> 람다식


## 추가사항
- UserLevelUpgradePolicy 인터페이스 분리 (p348)
  - 이후 예제 진행을 위해 Revert 수행함.


## 참고자료
- [H2 데이터베이스 설치 및 사용](https://velog.io/@codemcd/H2-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%84%A4%EC%B9%98-%EB%B0%8F-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
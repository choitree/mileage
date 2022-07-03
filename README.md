# 트리플여행자 클럽 마일리지 서비스

## SPEC
* Spring Boot 2.7.1
* Java 11
* QueryDSL 1.0.10
* MySQL 8.0.29
* JPA

---
## 실행방법

### Docker-compose
```
git clone https://github.com/choitree/mileage.git
cd mileage
./gradlew assemble
docker-compose up -d --build
```

### AWS 배포

[배포주소](http://13.125.200.78:8080)로 접속하여 확인 가능합니다.  
[POSTMAN](https://documenter.getpostman.com/view/15294373/UzJEUKnG)에서 예시 확인 가능합니다.

---

## ETC 
[DDL](https://github.com/choitree/mileage/wiki/DDL)과, [ERD](https://github.com/choitree/mileage/wiki/ERD) 및 [요구사항](https://github.com/choitree/mileage/wiki/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD)은 WIKI에서 확인 가능합니다.

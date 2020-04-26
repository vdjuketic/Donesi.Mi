# Donesi.mi
Donesi.mi is an online service where you can connect with people who are traveling abroad and commission them to
purchase various items for you. If you are going abroad you can connect with people
who would like to have some items purchased for them for a small fee decided by you.

Architecture is based on microservices which communicate with each other via REST calls.

### Technologies

* [Spring Boot] - Quick setup of microservices
* [Spring Cloud] - Specifically the Netflix OSS

### Netflix OSS components used

* [Eureka] - Service discovery
* [Hystrix] - Circuit breaker
* [Zuul] - Api Gateway

### Database

* [H2] - H2 in-memory database used for development
* [Hibernate] - ORM used

[Spring Boot]: <https://spring.io/projects/spring-boot>
[Spring Cloud]: <https://spring.io/projects/spring-cloud>
[Eureka]: <https://spring.io/projects/spring-cloud-netflix>
[Hystrix]: <https://spring.io/projects/spring-cloud-netflix>
[Zuul]: <https://spring.io/projects/spring-cloud-netflix>
[H2]: <https://www.h2database.com/html/main.html>
[Hibernate]: <https://hibernate.org/>

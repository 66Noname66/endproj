
```md
# Minions API (Spring Boot)

Educational REST API built with **Spring Boot + JPA + PostgreSQL**  
for managing minions (Warrior / Scout / Mage).

This project demonstrates:
- REST controllers
- JPA (Single Table Inheritance)
- Builder + Factory patterns
- Data filtering
- Working with Postman

---

##  Technologies

- Java 17+ (you are using Java 25)
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Hibernate

---
 ## Screenshots
<img width="729" height="1102" alt="Снимок экрана 2026-02-08 205235" src="https://github.com/user-attachments/assets/e5e22fa5-2f20-47f4-bd49-f4cabc9a3604" />
<img width="1527" height="1260" alt="Снимок экрана 2026-02-08 205338" src="https://github.com/user-attachments/assets/654ef245-c184-4bd9-ac31-a1e1f6269c2d" />
<img width="1699" height="1313" alt="Снимок экрана 2026-02-08 205458" src="https://github.com/user-attachments/assets/3550fe75-7950-4e1c-96cd-0da219670c3e" />




##  Project Structure

```

src/main/java/org/example/minionsapi
├── controller        # REST controllers
├── dto               # Request DTOs
├── model             # Entities (Minion, Warrior, Scout, Mage)
├── patterns          # Builder + Factory
├── repository        # JPA Repository
├── service           # Business logic
├── utils             # Validators
└── MinionsApplication.java

````

---

##  Data Model

### `minions` table

| field | type |
|---|---|
| id | bigint |
| name | varchar |
| age | int |
| city | varchar |
| skill | varchar |
| type | varchar |

 Uses **one field `skill`**  
 **Does NOT use** `power / speed / intelligence`.

---

## ️ application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/minions
spring.datasource.username=postgres
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````


## Run Application

1. Start PostgreSQL
2. Create database `minions`
3. Run `MinionsApplication`
4. Server will start at:

```
http://localhost:8080
```


##  REST API

###  Create a minion

**POST** `/api/minions`

```json
{
  "name": "Kevin",
  "age": 15,
  "city": "New York",
  "skill": "Strength",
  "type": "WARRIOR"
}
```


###  Get all minions

**GET** `/api/minions`


###  Filtering

#### By skill

```
GET /api/minions?skill=Strength
```

#### By type

```
GET /api/minions?type=MAGE
```

#### By city

```
GET /api/minions?city=Paris
```


##  Design Patterns Used

### Factory

Creates the correct minion type:

* `WARRIOR → Warrior`
* `SCOUT → Scout`
* `MAGE → Mage`

### Builder

Step-by-step construction of `Minion` objects.


## Implemented Features

✔ REST API
✔ JPA + Hibernate
✔ Inheritance (`SINGLE_TABLE`)
✔ Filtering
✔ Type validation
✔ Global error handling


##  Project Purpose

Educational project to understand:

* Spring Boot
* REST APIs
* JPA / Hibernate
* Backend application architecture


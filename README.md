
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


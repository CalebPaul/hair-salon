# _Hair Salon_

#### _Epicodus Java, 9-23-16._

#### By _**Caleb Paul**_

## Description

_This program will manage staff and customer relations for a hair salon._
_User can add, delete, and update info for Clients and Stylists, and assign clients to a specific stylist._

## Specs

* When user adds a stylist:
  - program adds stylist to database.

* When user adds a client:
  - client is assigned to a specific stylist.
  - client details (name, favorite haircut) are added to database.

* When user updates stylist info:
  - program changes stylist detail (name), and saves update to the database.

* When user updates client info:
  - program changes client details (name, favorite haircut) and saves update to the database.

* When user deletes stylist info:
  - program removes stylist from database.

 * When user deletes client info:
  - program removes client form database.

## Setup

* Clone this repository.

* Type in terminal:
	`postgres`

* Open new terminal window & Type in PSQL:
	  `CREATE DATABASE hair_salon;`

* Type in terminal:
	  `psql media < salon.sql`

* Type in terminal:
	`\c hair_salon`

* Type in terminal:
	  `gradle run`

* Use web browser to navigate to:
	`localhost:4567`


## Contact

Twitter @calebpaulmusic

## Technologies Used

* Java

* Gradle

* Postgres

* SQL

* VelocityTemplateEngine

* JUnit

* Spark

### License

*This webpage is licensed under the GPL license.*

Copyright (c) 2016 _Caleb Paul_

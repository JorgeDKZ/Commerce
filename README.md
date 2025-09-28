## Introduction
**Comerce** is my first proyect what i am using spring boot with microservice architecture.
But now only the back-end is present in the proyect but i will create the backend in the next update.

## Services
* **MySQL** <p>
   * Host: localhost <p>
   * Port: 3306

* **Configuration** <p>
  * Host: localhost <p>
  * Port: 8888  <p>
  * Microservice name: microservice-config

* **Eureka** <p>
  * Host: localhost  <p>
  * Port: 8761  <p>
  * Microservice name: microservice-eureka

* **Gateway** <p>
  * Host: localhost  <p>
  * Port: 8080  <p>
  * Microservice name: microservice-gateway

* **Client** <p>
  * Host: localhost  <p>
  * Port: 8090  <p>
  * Microservice name: microservice-client  <p>
  * MySQL: microservice-clients

* **Product** <p>
  * Host: localhost  <p>
  * Port: 8091  <p>
  * Microservice name: microservice-product  <p>
  * MySQL: microservice-products

* **Order** <p>
  * Host: localhost  <p>
  * Port: 8092  <p>
  * Microservice name: microservice-orderservice  <p>
  * MySQL: microservice-orderservices

## End Points
**Clients** <p>
```localhost:8090/api/clients/create | To create a new user```


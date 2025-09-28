## Introduction
**Comerce** is my first proyect what i am using spring boot with microservice architecture.
But now only the back-end is present in the proyect but i will create the front-end in the next update.

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
* ```localhost:8090/api/clients/create | To create a new client```
* ```localhost:8090/api/clients/all | To get all clients```
* ```localhost:8090/api/clients/search/{id} | To get a specific client```

**Products** <p>
* ```localhost:8091/api/products/create | To create a new product```
* ```localhost:8091/api/products/all | To get all products```
* ```localhost:8091/api/products/search/{id} | To get a specific product```
* ```localhost:8091/api/products/update/{id} | To update a specific product```

**Clients** <p>
* ```localhost:8092/api/orders/create | To create a new order```
* ```localhost:8092/api/orders/all | To get all orders```
* ```localhost:8092/api/orders/search/{id} | To get a specific order```
* ```localhost:8092/api/orders/user/{id} | To get all product from user```


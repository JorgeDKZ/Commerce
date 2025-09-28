## Introduction
**Comerce** is my first proyect what i am using spring boot with microservice architecture.
But now only the back-end is present in the proyect but i will create the backend in the next update.

## Services
**MySQL** <p>
Host: localhost
Port: 3306

**Configuration** <p>
Host: localhost
Port: 8888
Microservice name: microservice-config

**Eureka** <p>
Host: localhost
Port: 8761
Microservice name: microservice-eureka

**Gateway** <p>
Host: localhost
Port: 8080
Microservice name: microservice-gateway

**Client** <p>
Host: localhost
Port: 8090
Microservice name: microservice-client
MySQL: microservice-clients

**Product** <p>
Host: localhost
Port: 8091
Microservice name: microservice-product
MySQL: microservice-products

**Order** <p>
Host: localhost
Port: 8092
Microservice name: microservice-orderservice
MySQL: microservice-orderservices

## End Points
**Clients** <p>
```localhost:8090/api/clients/create | To create a new user```


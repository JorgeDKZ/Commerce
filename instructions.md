1\. **Servicio de Usuarios (User Service)**



Gestiona la información de los usuarios (clientes).



Endpoints principales:



POST /users → registrar un nuevo usuario.



GET /users/{id} → obtener info de un usuario.



GET /users → listar usuarios.



Tabla users en MySQL





**2. Servicio de Productos (Product Service)**



Gestiona el catálogo de productos.



Endpoints:



POST /products → registrar un nuevo producto.



GET /products/{id} → obtener info de un producto.



GET /products → listar productos disponibles.



Tabla products en MySQL





**3. Servicio de Pedidos (Order Service)**



Gestiona los pedidos realizados por los usuarios.



Depende de los servicios de Usuarios y Productos.



Endpoints:



POST /orders → crear un nuevo pedido (verifica que el usuario existe y que los productos tienen stock suficiente).



GET /orders/{id} → obtener info de un pedido.



GET /orders/user/{userId} → listar pedidos de un usuario.



Tablas: order, order\_item.









**🔗 Comunicación entre microservicios**



Usar REST APIs (con RestTemplate o WebClient).



Ejemplo: Cuando el servicio de pedidos crea un pedido, consulta al User Service para validar el usuario y al Product Service para verificar stock.



**⚙️ Infraestructura**



Cada microservicio tiene:



Base de datos MySQL propia (evita compartir DB en microservicios).



Su propio proyecto de Spring Boot.



Su archivo application.yml con configuración de puerto y DB.



Para gestión y orquestación puedes usar:



Spring Cloud Netflix Eureka (descubrimiento de servicios).



Spring Cloud Gateway (API Gateway).



Opcional: Docker Compose para levantar MySQL y los microservicios.



**🎯 Retos extra**



Manejar transacciones distribuidas (por ejemplo, rollback si no hay stock en productos al crear pedido).



Agregar autenticación con JWT en el servicio de usuarios.



Agregar un servicio de notificaciones (ej: cuando se crea un pedido, enviar un correo simulado).



Exponer métricas con Spring Boot Actuator.



Contenerizar todo con Docker y orquestar con Docker Compose o Kubernetes.



**👉 Este ejercicio es lo bastante grande para que practiques:**



Diseño de microservicios.



Persistencia con MySQL.



Comunicación entre microservicios.



Integración de Spring Boot con librerías de Spring Cloud.







2 semanas para hacerlo


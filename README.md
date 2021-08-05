## Proyecto 5 - Módulo Spring Boot

### Enunciado de la práctica:

Creación de aplicación con Spring Boot que incorpore las siguientes funcionalidades
y tecnologías.

**Tecnologías:**

- Configuración base de datos MySQL o PostgreSQL con datos de prueba en el arranque de la aplicación, introducidos a través de fichero data.sql o a través de la clase main.

- Swagger para la documentación de la api, con los métodos de cada controlador documentados y los atributos de las entidades también documentados.

- Pruebas de cada método de cada controlador con Postman. Exportar la colección Postman y añadirla en la carpeta raíz del proyecto.

**Funcionalidades:**

- 2 entidades: Usuario, Empresa. Crear atributos correspondientes para cada
una de diferente tipo de dato, son independientes la una de la otra, no habrá
relaciones entre ambas.

- Implementación de capas: controlador, servicio, repositorio para cada entidad,
donde se definan los métodos CRUD.

- Ambos controladores deberían incluir algún método para filtrar por atributo
diferente a la clave primaria, por ejemplo el nombre.

- En el controlador de empresa debe incluir un método que permita calcular la
facturación de la empresa a partir de los atributos número de empleados,
número de productos y años en el mercado, los criterios para el cálculo son a
libre elección
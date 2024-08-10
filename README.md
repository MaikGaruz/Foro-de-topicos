# Foro-topicos
 Foro sencillo para entender: API REST, que tambien es parte de la solucion
 del Alura Challengue.

 
- IDEs: IntelliJ IDEA y MySQL Workbench
- Lenguajes: Java, SQL, JPQL
- Framework: Spring boot
- Herramientas: Flyway, Lombok, Hibernate, JPA, Jackson DataBind, Insomniac
  
 Este foro funciona mediante requisiciones, las cuales son las siguientes:
 
![image](https://github.com/user-attachments/assets/1cc76d7a-d405-46fb-b711-2eadd09a4bfe)



Con esto podemos ir dandonos una pequeña idea de la funcionalidad de la API REST;
Tenemos la posibilidad de regitrar un usuario y darle una clave y hacer la autenticacion.
Ademas, a modo general podemos:
- Crear usuarios con el topico que pondran, 
- Modificar el mensaje y el status de su topico,
- Listar a todos los que hayan participado y
- Borrar a los usuarios.
  
Toda esta informacion de almacena en una Base de datos (En este caso se uso MySQL Workbench) para lograr la dichosa persistencia de datos
con la dependencia de JPA.
Este proyecto fue hecho con Spring Boot y las requisiciones para probar que todo funcionara correctamente se utilizo Insomniac.



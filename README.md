# Quipildor-Backend-Portfolio
# PORTFOLIO para Argentina Programa

Este proyecto es el trabajo final del curso de Argentina Programa, dictado por el INTI (Instituto Nacional de Tecnología Industrial). Dicho 
proyecto se trata de un portfolio personal que permita su edición, y sea desarrollado en Angular usando Spring Boot y una Base de Datos en 
MySQL.

El proyecto está en 2 repositorios, este para el Backend y otro para el Frontend. 
Frontend:

              https://github.com/kipildor/Quipildor-Frontend-Portfolio

Entre las características de este proyecto podemos mencionar que cuenta JWT (JSON Web Token) sin el manejo de roles (por ahora, en una futura 
revisión se espera implementarlos), también utiliza el servicio de Cloudinary para almacenar las imágenes que se suban en los formularios. 
También implementa JPA (Java Persistence API)

# Tecnologías
Angular - Spring Boot - MySQL

# Vinculación a la Base de Datos
Para vincular el Backend con la Base de Datos tenemos el archivo "application.properties", dentro de la carpeta resources ubicada en:
             
             "src > main > resources"

En dicho archivo debemos colocar la dirección de donde está nuestra Base de Datos, con su puerto y el nombre de la Base de Datos, otros 
campos que deberemos modificar son los referentes al usuario y la contraseña de la Base de Datos.

# Creación de la Base de Datos
Una vez que creemos la conexión a la Base de Datos por medio de lo ingresado en "application.properties", creamos la Base de Datos con el 
nombre elegido y corremos nuestro Backend, esto creará las tablas con las relaciones*.

# Creación de los roles y usuarios
En el archivo "CreateRoles.java" ubicado en:

             src > main > java > com > quipildor > portfolio > util

En ese archivo encontramos un @Component comentado, debemos descomentarlo completo, colocar el e-mail y el password que queramos asignar, 
y después correr nuevamente nuestro Backend, esto llenará las tablas de los roles del JWT y agregara una Persona con el e-mail y password 
que colocaron, hay que tener en cuenta que esto no creará el usuario con el que loguearse,** para ello podríamos usar Postman y que use 
el método de JWT para agregar un usuario nuevo.***
*******IMPORTANTE*********
Una vez corrido el código que descomentamos en el archivo "CreateRoles.java", debemos volver a comentarlo.

# Aclaraciones
* Originalmente la Base de Datos fué creada con todas sus tablas relacionadas, pero debido a distintos inconveniente (Y la fecha de entrega 
tan cercana), las relaciones fueron eliminadas (excepto las de JWT) dejando solo sus FK para "relacionarlas".

** Al sistema así como le falta un registro para nuevos usuarios (solo se crea uno al comienzo, en el código que descomentamos, y de este es 
que modificamos los datos en nuestra página) también le faltaría una vinculación entre los usuarios del JWT y las Personas de nuestra página 
(que al crear uno se cree otro en la otra tabla, con el mismo e-mail y password).

*** En Postman para crear el usuario del JWT (con el que nos logueamos), podríamos hacer así:
Elegimos el método POST
Ponemos la dirección de nuestra Base de Datos con la dirección del método del Controller para crear el nuevo usuario (si trabajaramos 
localmente, pondríamos algo así en la dirección:

             localhost:8080/auth/nuevo
Y seleccionamos las opciones "Body", dentro de la misma elegimos "raw", y que sea del tipo JSON. Ahora solo nos quedaría modificar el cuerpo 
de la petición con los datos a enviar, si queremos un usuario del tipo ADMIN colocamos esto:

    {"nombre": "lean", "nombreUsuario": "leandro_1980@live.com.ar", "email": "leandro_1980@live.com.ar", "password": "1234", "roles": ["admin"]}

Si quisiéramos un usuario del tipo "user" seguiríamos el siguiente ejemplo:
   
    {"nombre": "user", "nombreUsuario": "user@gmail.com.ar", "email": "user@gmail.com.ar", "password": "user", "roles": ["user"]}

# DER

![DER_Portfolio](https://user-images.githubusercontent.com/2695780/182040838-0b5ff530-ce57-464a-b718-73cf95075bce.jpg)
El diagrama está desactualizado, entre la entidad Usuario y la entidad Persona debería haber una relación 1:1, y tal vez una herencia entre la entidad Imagen(Cloudinary) y las entidades Persona, Exp_lab, Educación, Img_proy, ya que una vez subida la imagen a Clodinary se graban en Imagen y algunos de esos datos en las otras entidades mencionadas según corresponda.

# Imagen de la BD

![DB_Portfolio_sin_relaciones](https://user-images.githubusercontent.com/2695780/182040865-9efbe7b5-6a96-47d3-967c-5ba6e41f20c0.png)
Si bien las tablas, en su mayoría, tenian relaciones entre ellas por no conseguir grabar algunos campos FK y la falta de tiempo de encontrar otra solución, dichas relaciones fueron eliminadas, y se mantuvieron los campos que las relacionaban.

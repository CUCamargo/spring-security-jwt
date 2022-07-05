# spring-security-jwt

Intrucciones de compilado
 Descargar el proyecto
 Abrir IDE e importar como proyecto maven
 Verificar que todas las dependencias esten descargadas
 Abrir Application.java dar clic derecho y Ejecutar
 
 Instrucciones de ejecución
  Una vez iniciado Tomcat abrir Postman
  
  ####Ver lista###
  Crear una solicitud GET con el sig link http://localhost:8080/servicios/listaempleados
  Clic en enviar y aparecera un mensaje de que no hay datos en BD (H2)
  
  ####Ingresar info###
  Crear una solicitud POST con el sig link http://localhost:8080/servicios/añadirempleado
  En el body ingresar la info deseada, ejemplo: 
      {
        "surname" : "Garcia",
        "firstname" : "Lupe"
      }
  Verificar con la solicitud GET http://localhost:8080/servicios/listaempleados y deberá aparecer la info ingresada
  
  ####Buscar info por ID###
  Crear una solicitud GET con el sig link http://localhost:8080/servicios/detalleempleado/1
  Al enviar la petición deberá mostrar la info ingresada con el ID 1
  **Nota: el ID es autogenerado por lo que en caso de eliminar el registro no se podrá usar más ese ID y por ende no aparecerá
  
  ####Modificar info###
  Crear una solicitud PUT con el sig link http://localhost:8080/servicios/actualizaempleado/1
  en donde el ultimo numero del link hace referencia al ID de registro
  En el body ingresar la info deseada con la modificación, ejemplo:
  {
    "surname": "Garcia",
    "firstname": "Lu"
  }
  Verificar con la solicitud GET http://localhost:8080/servicios/listaempleados
  
  ####Eliminar info###
  Crear una solicitud DEL con el sig link http://localhost:8080/servicios/eliminaempleado/1
  en donde el ultimo numero del link hace referencia al ID de registro
  Verificar con la solicitud GET http://localhost:8080/servicios/listaempleados
  
  
  ******Links de operaciones******
  
  FindAll
  http://localhost:8080/servicios/listaempleados
  http://localhost:8080/servicios/listaairport
  http://localhost:8080/servicios/listapais
  http://localhost:8080/servicios/listalenguajes
  
  FindById
  http://localhost:8080/servicios/detalleempleado/1
  http://localhost:8080/servicios/detalleairport/1
  http://localhost:8080/servicios/detallepais/1
  http://localhost:8080/servicios/detallelenguajes/1
  
  Delete
  http://localhost:8080/servicios/eliminaempleado/1
  http://localhost:8080/servicios/eliminaairport/1
  http://localhost:8080/servicios/eliminapais/1
  http://localhost:8080/servicios/eliminalenguajes/1
  
  Update
  http://localhost:8080/servicios/actualizaempleado/1
  http://localhost:8080/servicios/actualizaairport/1
  http://localhost:8080/servicios/actualizapais/1
  http://localhost:8080/servicios/actualizalenguajes/1
  
  
  
  
  
  
  
  
  
  
  
  

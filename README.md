# pruebaPDF

-¿Cómo harías para poder ejecutar N veces el proceso sobre el mismo directorio y solo modificar cada pdf una sola vez?

La idea que se me ocurre es cambiar el nombre del archivo para dejar alguna indicación de que ya se ha tratado. Después modificar el código para que detecte esa señal en el nombre y que salte el archivo y lo mantenga sin modificar.

-¿Qué pasa si el directorio contiene un fichero que no es un pdf?

Saltará una excepción que esta tratada por código que envía un mensaje de error indicando que ese archivo no se ha podido modificar. El resto del proceso continua sin detener la aplicación

-¿Cómo probar / ejecutar la aplicación?

Se tiene que descargar el proyecto e importarlo dentro de tu IDE. Después se ejecuta el archivo main.

-¿Cómo podemos ver los logs?

Los logs se guardan dentro del directorio "\src\main\resources\Log".

FROM openjdk:17
EXPOSE 4040
ADD target/mvc_crud.jar mvc_crud.jar
ENTRYPOINT [ "java","-jar","/mvc_crud.jar" ]
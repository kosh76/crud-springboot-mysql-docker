crud-springboot-mysql-docker
## Описание: ЭТО REST SERVER на Spring boot c подключением к базе данных MYSQL работающих в Docker. Проект и описание установки - это демонстрация того,
## что я знаком с данной технологией. Создается контейнер для mysql и отдельный контейнер для приложения. Контейнеры общаются в общей сети. Также можно использовать docker-compose. 
### Как запустить проект в Docker:
- установить Docker https://www.docker.com/products/docker-desktop
- скачать образ MySQL:5.7 c Docker hub : docker pull mysql:5.7
- скачать образ приложения с Docker hub: docker pull koshelev2011/docker-demo:v1.0 
-  ваши скаченные образы можно посмотреть командой: docker images
- создать сеть : docker network create my_net
- чтобы запустить контейнер mysql:5.7/ выполни команду:
docker run --name mysql --rm -d -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=my_db -e MYSQL_PASSWORD=bestuser -e MYSQL_USER=bestuser --network my_net mysql:5.7
- чтобы запустить контейнер с приложением выполни команду:
docker run --name docker-demo -d --rm  -p 8080:8080 --network my_net koshelev2011/docker-demo:v1.0
- чтобы посмотреть работающие контейнеры, выполни команду : docker ps
- чтобы посмотреть контейнеры в сети my_net, выполни команду : docker network inspect my_net
- для проверки работы приложения воспользуйся Postman https://www.postman.com/downloads/
- получи всех юзеров : localhost:8080/users
- добавь юзера :метод POST http://localhost:8080/addUser   ///json {
   "name":"ivan",
   "surname":"ivan",
   "email":"ivan@mail.ru"
}
- получи юзера по ID: http://localhost:8080/findUser/1
- удали юзера по ID : метод DELETE http://localhost:8080/deleteUser/1
- остановит контейнер : docker stop docker-demo, docker stop mysql
- удалить образ : docker rmi  koshelev2011/docker-demo:v1.0
## ENJOY!

# sb_assignment

### How to run

get database docker image from https://hub.docker.com/r/genschsa/mysql-employees/

run the image:

docker run -d \
  --name mysql-employees \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=college \
  -v $PWD/data:/var/lib/mysql \
  genschsa/mysql-employees
  
Run the application:

./mvnw spring-boot:run



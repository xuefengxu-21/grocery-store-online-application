clean:
	gradle clean
	rm -rf bin

compile:
	gradle build

test:
	gradle test

jar: 
	gradle build -x test
	gradle bootJar

run: jar
	echo Starting Spring at:  http://localhost:8080
	java -jar build/libs/customer-management-1.0.jar

# Docker
docker-build:  clean jar
	docker build -t customer-management .
	docker images

docker-push:
	docker login
	docker build -t xuefeng89/customer-management:v1 .
	docker push xuefeng89/customer-management:v1
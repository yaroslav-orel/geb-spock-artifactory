# Geb-spock-artifactory

## Prerequisites: 
- Java 8+
- Chrome 60+

## Set up environment:
- Download Artifactory-oss
```
docker pull docker.bintray.io/jfrog/artifactory-oss:latest
```
- Launch Artifactory-oss
```
docker run --name artifactory -d -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```
- Complete initial configuration: 
	- Create user with credentials: admin / Password1
	- Create Gradle project repository 'gradle-dev-local'
	
## Run tests: 
```
./gradlew clean test
```

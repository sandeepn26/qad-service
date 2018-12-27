# League Panda Service

## Local Setup
- Install MySQL 5.6. 

- Install Java 1.8

- Maven 3.x

- Download Eclipse Oxygen or similar

- git clone https://github.com/sandeepn26/leaguepanda-service.git

- Initialize the db using /dbtools/initdb.cmd or initdb.sh based or your OS. enter the root user password when prompted

- If it complains that the `leaguepanda` user does not exist, comment out the first `drop user` line for the first time and run initdb.

- Use the installed Maven in eclipse and not the embeded one. To do so 

- Go to Window > preferences > Maven > Installations > Add and add the Maven Installation directory

- Update the Maven runtime for the targets. Example Right click on pom.xml > run as > run configurations > Maven runtimes and select the installed one

## Running locally

- You mostly don't have to change anything in application.properties unless you're using a port other than 3306 for mysql, set your db credentials and update the spstore.properties with your db password

- From the command line `spring-boot:run` OR Add a new run configuration in eclipse pom.xml > run as > run configurations > new and add target spring-boot:run and name it league_panda

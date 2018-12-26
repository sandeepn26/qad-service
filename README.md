# CLS Trade Monitor

## Local Setup
- Install Java 1.8

- Maven 3.x

- Download Eclipse Oxygen or similar

- Pull the project from //dev-fxcts/branch/gtss_9.14.tomcat/ branch and import them into eclipse as a maven project

- Use the installed Maven in eclipse and not the embeded one. To do so 

- Go to Window > preferences > Maven > Installations > Add and add the Maven Installation directory

- Update the Maven runtime for the targets. Example Right click on pom.xml > run as > run configurations > Maven runtimes and select the installed one

## Running locally

- In application.properties, set your db credentials and update the spstore.properties with your db password

- Add the following VM argument to the run configuration to avoid certificate errors pom.xml > run as > run configurations > JRE

	`Dmaven.wagon.http.ssl.insecure=true`

- Add a new run configuration in eclipse pom.xml > run as > run configurations > new and add target spring-boot:run and name it cls_trade_monitor

- Run the app and you should see the number of clients and trades fetched from the CLS API in the logs

## Testing

- The quartz scheduler is set to currently initiate the update trades job once on startup.

- If you want to initiate an adhoc request http://localhost:8080/clients. to update clients /trades for trades and /token to get a token

- Note: trades and clients end points refresh the token everytime and you don't need to get one
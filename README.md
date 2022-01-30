# 1. Project's Title
Skenariolabs portfolio buildings

# 2. Project Description
This is a Springboot REST API application running in a maven JDK environment for managing buildings portolio <br/>
Generally, you could: 
- Add new building based on (Name of building, Street, Number, Postal code, City, Country, Description).
- Coordinates will be found automatically based on the address using geoapify.
- View all buildings.
- View specific building details based on its name.
- Update a building name or description

# 3. How to Install and Run the Project

There are 3 ways of running this project:

* Through the deployed version over GCP.
* Through Docker container from an image.
* Through your local machine (mvn).

####  <u>I- Through the deployed version over GCP:</u>

This is the simplest of way of running the project as it doesn’t require any pre installations or configurations. You could just send the requests through this [link](https://skenario-assign-f32wyhbvoq-lz.a.run.app/) but you need to have the POSTMAN installed or any other restful clients for making the requests.

####  <u>II- Through Docker container from an image:</u>
This is recommended way as it saves time.

Prerequisites:
-	You need to have docker desktop installed and running in your computer, in case you don’t have docker installed in your machine, See these instructions from [Docker website](https://docs.docker.com/engine/install/).

Running the project:

-	Simply type in the CMD or terminal the following command:

```
docker run -p 8080:8080 anoirsa/skenario_assign
```
#####  (Note: the application runs on PORT 8080 inside the container, you could map it with any other port in   your local machine. Doesn’t have to be necessarily 8080)

####  <u>III- Through your local machine (mvn)</u>
Prerequisites:
- If you are not using IntelliJ IDEA you need to have maven installed in your machine.
  
Running the project:
- If you are not using IntelliJ IDEA go to the root directory of the project and type through terminal or CMD:

```
mvn spring-boot:run
```
- If you want to run the test cases then type

```
mvn test
```
- If you are using IntelliJ IDEA then you could just press the RUN icon on the top. You could also run the tests.

# 4. How to use the project
Firstly, this video of demonstration explains in 8min very well how to use the project it is recommended to watch it if you have time.

###  1) Swagger documentation:
If you want to take a look at swagger documentation you browse to (http://localhost:8080/swagger-ui/index.html)

###  2) Endpoints:

<b>_- Endpoint POST (/api/v4/buildings/addbuilding)_</b>: You insert a new building to our embdded sql database and coordinates will be found automatically 

       Request example:
       http://localhost:8080/api/v4/buildings/addbuilding
       Request body:
       {
       "buildingName": "Tekla 2",
       "buildingStreet": "Palosaarentie",
       "buildingNumber": "60",
       "buildingCity": "Vaasa",
       "buildingCountry": "Finland",
       "buildingDescription": "Educational institution",
       "buildingPostalCode": 65200
        } 

##### Note: Don't add coordinates as they will be fetched automatically through the request 

<b>_- Endpoint GET (/api/v4/buildings)_</b>: You get all the buildings in our sql embedded database.

       Request example:
       http://localhost:8080/api/v4/buildings

<b>_- Endpoint PUT (/api/v4/buildings/update/buildingName={buildingName})_</b>: You update a building based on its name and set a new name and new description

       Request example:
       http://localhost:8080/api/v4/buildings/update/buildingName=Tekla 2
       Request body:
       {
       "buildingName": "Tekla 3",
       "buildingDescription": "New institution in our guard",
        } 

<b>_- Endpoint GET (/api/v4/buildings/find/buildingName={buildingName})_</b>: Find a building details based on its name.

       Request example:
       http://localhost:8080/api/v4/buildings/find/buildingName=Vaasa university of applied sciences

# 5. License and Credits:
This project has been fully developed by Anouar Belila.








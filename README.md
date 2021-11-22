Coverage: 10%

Project Title

Exercise and Workout Plan OOP based Web Application.

Getting Started

Create Backend using Springboot. Initialiase Entity for exercise and Workout Plan. Create Repo extending JPARepository. Create Service using JPARepository functions to produce CRUD functionality. Create controller to allow data transfer between backend and frontend. create testing files.

Creating Frontend using VisualStudioCode.
Create webpage html files and include any forms/scripts.
create relating javascript files to webpages to handle data as JSON.

Prerequisites

Software used: Eclipse, MySQLServer, Postman, VisualStudioCode

requires: Java Developer Kit, SQL community server.

Setting up

Create excercise assigning exercise name, muscle targeted, number of reps, number of sets. Assign excercise by excerciseID to a Workout plan using workoutplan sessionID.

![image](https://user-images.githubusercontent.com/91898712/142902897-7e64cff6-b95c-4f5b-bb4b-f89f9ba7d2c2.png)

And repeat

until finished

Running the tests

Unit Tests

Junit testing, 'mock' testing units of code for domain controller to determine created objects in front end and back end are identical. Ensures code was executable and that objects were being created correctly

@Test public void testCreate() { final Item created = new Item(1, "ball", 4.99); assertEquals(created, DAO.create(created)); } Integration Tests

Mockito testing of the object controller codes to ensure consistency in implementing create, read, update and delete statements in frontend.

@Test void testCreate() throws Exception {

	Excercise ex1 = new Excercise("Bench press", "chest",5,5);
	String ex1AsJSON = this.mapper.writeValueAsString(ex1);
	RequestBuilder request = post("/Excercise/create").contentType(MediaType.APPLICATION_JSON).content(ex1AsJSON);

	ResultMatcher checkStatus = status().isCreated(); 

	Excercise exSaved = new Excercise("Bench press", "chest",5,5);
	String exSavedAsJSON = this.mapper.writeValueAsString(exSaved);

	ResultMatcher checkBody = content().json(exSavedAsJSON);

	this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

}
}

coding style tests Coverage tests to determine the percentage of code units which have been tested.

coverage as Junit Deployment

Built With Maven - Dependency Management

Versioning Github was used for version control.

Authors Eamon Moradi

Acknowledgments

Hat tip to anyone whose code was used Inspiration etc

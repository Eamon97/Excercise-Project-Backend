
	DROP TABLE IF EXISTS `Excercise` CASCADE;
CREATE TABLE `Excercise`(
	`excerciseID` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`excerciseName` VARCHAR(255) NOT NULL,
	`muscleTargeted` VARCHAR(255) NOT NULL,
    `noOfReps` INT(30),
	`noOfSets` INT(30),
	`sessionID` BIGINT, FOREIGN KEY(sessionID) REFERENCES WorkoutPlanDB(sessionID)
    );
	
	DROP TABLE IF EXISTS `WorkoutPlanDB` CASCADE;
	CREATE TABLE `workoutPlanDB`(
	`sessionID` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`dayOfWeek` VARCHAR(14),
	`excerciseID` BIGINT, FOREIGN KEY (sessionID) REFERENCES Excercise(excerciseID)
	);
	
	
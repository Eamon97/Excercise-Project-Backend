CREATE SCHEMA `WorkoutPlanDB`;
Use `WorkoutPlanDB`;

	DROP TABLE IF EXISTS `Excercise` CASCADE;
CREATE TABLE `Excercise`(`excerciseID` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`excerciseName` VARCHAR(255) NOT NULL,
	`muscleTargeted` VARCHAR(255) NOT NULL,
    `noOfReps` INT(30),
	`noOfSets` INT(30)
    );
	
	DROP TABLE IF EXISTS `WorkoutPlan` CASCADE;
	CREATE TABLE `WorkoutPlan`(
	`sessionID` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`dayOfWeek` VARCHAR(14),
	`excerciseID` BIGINT, 
    FOREIGN KEY (excerciseID) REFERENCES Excercise(excerciseID)
	);
	
	
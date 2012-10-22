delimiter $$

CREATE DATABASE `tinyzilla` /*!40100 DEFAULT CHARACTER SET latin1 */$$


CREATE  TABLE `tinyzilla`.`bug` (
  `bug_id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`bug_id`) );


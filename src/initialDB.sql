DROP TABLE IF EXISTS activ_categories;
DROP TABLE IF EXISTS activities;
DROP TABLE IF EXISTS admins;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_activities;

CREATE TABLE activ_categories (
  activ_categoryID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  activ_category_name_ua varchar(32) NOT NULL,
  activ_category_name_en varchar(32) NOT NULL
);


CREATE TABLE activities (
  activityID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  activity_name_ua varchar(32) NOT NULL,
  activity_name_en varchar(32) NOT NULL,
  init_date datetime NOT NULL,
  end_date datetime NOT NULL,
  activity_state enum('NOTSTARTED','PROCESS','FAILED') NOT NULL,
  activ_categoryID int NOT NULL,
  FOREIGN KEY (activ_categoryID) REFERENCES activ_categories(activ_categoryID)
);


CREATE TABLE admins (
  adminID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email varchar(32) NOT NULL
);

CREATE TABLE users (
  userID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email varchar(32) NOT NULL,
  user_name varchar(32) NOT NULL,
  password varchar(100) NOT NULL
);

CREATE TABLE users_activities (
  userID int NOT NULL,
  activityID int NOT NULL,
  PRIMARY KEY (userID, activityID),
  FOREIGN KEY (userID)  REFERENCES users (userID),
  FOREIGN KEY (activityID) REFERENCES activities (activityID)
);

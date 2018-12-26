--
-- Create the tables for proman
--
CREATE TABLE role (
  role VARCHAR(10) NOT NULL PRIMARY KEY,
  role_description VARCHAR(25) NOT NULL,
  role_long_description VARCHAR(256) NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date'
);

CREATE TABLE proman_user (
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique user id',
  email VARCHAR(80) NOT NULL,
  display_name VARCHAR(50) NULL,
  password CHAR(41) NOT NULL,
  failed_logins INT NOT NULL DEFAULT 0,
  enabled TINYINT(1) NOT NULL DEFAULT 1,
  locked TINYINT(1) NOT NULL DEFAULT 0,
  last_login_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'last login date',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  role VARCHAR(10) NOT NULL,
  UNIQUE INDEX (email),
  CONSTRAINT role_fk FOREIGN KEY (role) REFERENCES role(role)
);

CREATE TABLE user_detail (
  user_detail_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique user detail id',
  user_id INT NOT NULL,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  address VARCHAR(80) NOT NULL,
  city VARCHAR(30) NOT NULL,
  state CHAR(2) NOT NULL,
  post_code CHAR(7) NOT NULL,
  county CHAR(7),
  phone VARCHAR(15) NOT NULL,
  secondary_phone VARCHAR(15),
  secondary_email VARCHAR(80),
  date_of_birth TIMESTAMP NOT NULL COMMENT 'Date of Birth',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES proman_user(user_id) ON DELETE CASCADE
);

CREATE TABLE institution (
  institution_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique institution or owner id',
  institution_type VARCHAR(10) NOT NULL,
  institution_code VARCHAR(20) NOT NULL,
  institution_name VARCHAR(50) NOT NULL,
  institution_description VARCHAR(50) NULL,
  owner_id INT NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT owner_id_fk FOREIGN KEY (owner_id) REFERENCES proman_user(user_id) ON DELETE CASCADE
);

CREATE TABLE team_manager (
  manager_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique manager id',
  manager_user_id INT NOT NULL,
  finger_printing_done TINYINT(1) NOT NULL DEFAULT 0,
  assurance_waiver_signed TINYINT(1) NOT NULL DEFAULT 0,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT manager_user_id_fk FOREIGN KEY (manager_user_id) REFERENCES proman_user(user_id) ON DELETE CASCADE
);

CREATE TABLE team (
  team_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'The team id',
  team_type VARCHAR(10) NULL COMMENT 'Team type',
  team_code VARCHAR(20) NULL COMMENT 'Team Code',
  team_name VARCHAR(50) NOT NULL COMMENT 'The team name',
  team_description VARCHAR(50) NOT NULL COMMENT 'The team description',
  team_grade_min VARCHAR(10) NULL COMMENT 'Min qualifying grade',
  team_grade_max VARCHAR(10) NULL COMMENT 'Max qualifying grade',
  active TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'is active in current team',
  owner_id INT NOT NULL COMMENT 'Team owners id',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date'
);

CREATE TABLE student_grades (
  grade VARCHAR(10) NOT NULL PRIMARY KEY,
  grade_description VARCHAR(25) NOT NULL,
  grade_value INT NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  UNIQUE (grade_value)
);

CREATE TABLE student (
  student_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique student id',
  parent_guardian_id INT NOT NULL COMMENT 'Parent or Guardian id',
  first_name VARCHAR(50) NOT NULL COMMENT 'The first name',
  last_name VARCHAR(50) NOT NULL COMMENT 'The last name',
  school VARCHAR(50) NULL COMMENT 'The students school',
  grade VARCHAR(10) NULL COMMENT 'Kids grade',
  teacher VARCHAR(10) NULL COMMENT 'Teacher',
  food_allergies VARCHAR(50) NULL,
  other_conditions VARCHAR(50) NULL,
  authorized_pickup_persons VARCHAR(250) NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT parent_guardian_id_fk FOREIGN KEY (parent_guardian_id) REFERENCES proman_user(user_id) ON DELETE CASCADE
);

CREATE TABLE team_student (
  student_id INT NOT NULL COMMENT 'Student ID',
  team_id INT NOT NULL COMMENT 'Team ID',
  PRIMARY KEY (student_id, team_id),
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT team_student.student_id_fk FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE,
  CONSTRAINT team_student.team_id_fk FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE
);

CREATE TABLE team_manager_map (
  manager_id INT NOT NULL COMMENT 'Manager ID',
  team_id INT NOT NULL COMMENT 'Team ID',
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  PRIMARY KEY (manager_id, team_id),
  CONSTRAINT team_manager_map.manager_id_fk FOREIGN KEY (manager_id) REFERENCES team_manager(manager_id) ON DELETE CASCADE,
  CONSTRAINT team_manager_map.team_id_fk FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE
);
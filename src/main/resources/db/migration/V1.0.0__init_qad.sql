--
-- Create the tables for qad
--
use qad;

-- Current roles : ADMIN, PARENT, STUDENT
CREATE TABLE role (
  role VARCHAR(10) NOT NULL PRIMARY KEY,
  role_description VARCHAR(25) NOT NULL,
  role_long_description VARCHAR(256) NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date'
);

CREATE TABLE qad_user (
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique user id',
  email VARCHAR(80) NOT NULL,
  display_name VARCHAR(50) NULL,
  password CHAR(41) NOT NULL,
  failed_logins INT NOT NULL DEFAULT 0,
  enabled TINYINT(1) NOT NULL DEFAULT 1,
  locked TINYINT(1) NOT NULL DEFAULT 0,
  status VARCHAR(10) NOT NULL DEFAULT 'NEW',
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
  create_user INT NOT NULL,
  CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES qad_user(user_id) ON DELETE CASCADE
);

CREATE TABLE team (
  team_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'The team id',
  team_type VARCHAR(10) NULL COMMENT 'Team type',
  team_code VARCHAR(20) NULL COMMENT 'Team Code',
  team_name VARCHAR(50) NOT NULL COMMENT 'The team name',
  team_description VARCHAR(50) NOT NULL COMMENT 'The team description',
  team_age_min INT NOT NULL DEFAULT 4 COMMENT 'Min ages',
  team_age_max VARCHAR(10) NULL COMMENT 'Max qualifying grade',
  team_grade_min VARCHAR(10) NULL COMMENT 'Min qualifying grade',
  team_grade_max VARCHAR(10) NULL COMMENT 'Max qualifying grade',
  active TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'is active in current team',
  owner_id INT NOT NULL COMMENT 'Team owners id',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  create_user INT NOT NULL
);

CREATE TABLE member (
  member_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique student id',
  parent_guardian_id INT NULL COMMENT 'Parent or Guardian id',
  first_name VARCHAR(50) NOT NULL COMMENT 'The first name',
  last_name VARCHAR(50) NOT NULL COMMENT 'The last name',
  display_name VARCHAR(50) NOT NULL COMMENT 'The display name',
  display_image VARCHAR(50) NOT NULL COMMENT 'The image name or url',
  date_of_birth TIMESTAMP NOT NULL COMMENT 'Date of Birth',
  question_day INT NOT NULL DEFAULT 0 COMMENT 'Day of the week with 1 being Sunday',
  create_user INT NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT parent_guardian_id_fk FOREIGN KEY (parent_guardian_id) REFERENCES qad_user(user_id) ON DELETE CASCADE
);

CREATE TABLE qad_question (
  question_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT  'Unique question id',
  question TEXT NOT NULL COMMENT 'The question',
  question_image VARCHAR(250) NULL COMMENT 'The image name or url',
  create_member INT NOT NULL COMMENT 'The team member who created this question',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT create_member_fk FOREIGN KEY (create_member) REFERENCES member(member_id) ON DELETE CASCADE
);

CREATE TABLE qad_answer (
  answer_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Unique answer id',
  question_id INT NOT NULL COMMENT 'the question id',
  answer TEXT NOT NULL COMMENT 'The answer',
  answer_image VARCHAR(250) NULL COMMENT 'The image name or url',
  create_member INT NOT NULL COMMENT 'The team member who answered this question',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created date',
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT anscreate_member_fk FOREIGN KEY (create_member) REFERENCES member(member_id) ON DELETE CASCADE
);

CREATE TABLE team_member_map (
  member_id INT NOT NULL COMMENT 'team member ID',
  team_id INT NOT NULL COMMENT 'Team ID',
  PRIMARY KEY (member_id, team_id),
  updated_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Upated date',
  CONSTRAINT member_id_fk FOREIGN KEY (member_id) REFERENCES member(member_id) ON DELETE CASCADE,
  CONSTRAINT team_id_fk FOREIGN KEY (team_id) REFERENCES team(team_id) ON DELETE CASCADE
);

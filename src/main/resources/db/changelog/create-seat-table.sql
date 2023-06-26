CREATE TABLE seat (
  id INT AUTO_INCREMENT PRIMARY KEY,
  number VARCHAR(10) NOT NULL,
  trip_id INT,
  user_id INT,
  FOREIGN KEY (trip_id) REFERENCES trip(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);
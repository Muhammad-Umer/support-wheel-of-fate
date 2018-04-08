CREATE TABLE engineer(
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY ,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE shift(
  `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
  `engineer_id` INTEGER NOT NULL,
  `shift_date` DATE,
  `creation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updation_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY(engineer_id) REFERENCES engineer(id)
);


INSERT
INTO
  engineer(first_name,
  last_name,
  email)
VALUES('Paul', 'Johnson', 'paul.johnson@dummy.com'),('Mohammed', 'Ali', 'm.ali@dummy.com'),('Sarah', 'Baker', 'sarah.baker@dummy.com'),('Arjun', 'Kumar', 'arjun.kumar@dummy.com'),('Matt', 'Invanovic', 'matt.ivanovic@dummy.com'),('Tim', 'Bob', 'tim.bob@dummy.com'),('Farah', 'Naz', 'farah.naz@dummy.com'), ('Tom', 'Hanks', 'tom.hanks@dummy.com'),('Kurosaki', 'Ichigo', 'kurosaki.ichigo@dummy.com'),('Mikasa', 'Ackerman', 'mikasa.ackerman@dummy.com');
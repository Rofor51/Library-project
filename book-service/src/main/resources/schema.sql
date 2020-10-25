CREATE TABLE book (
     id SERIAL  PRIMARY KEY,  -- implicit primary key constraint
     title    VARCHAR(50) NOT NULL,
     pages    INT NOT NULL,
     date     DATE NOT NULL,
     imageLink VARCHAR(50) NOT NULL,
     instore    BOOL NOT NULL
);

CREATE TABLE author (
      id  SERIAL  PRIMARY KEY,
      name     VARCHAR(50) NOT NULL,
      last_name VARCHAR(50)
);

CREATE TABLE author_book (
      book_id    SERIAL  REFERENCES book (id) ON UPDATE CASCADE ON DELETE CASCADE,
      author_id SERIAL  REFERENCES author (id) ON UPDATE CASCADE

);
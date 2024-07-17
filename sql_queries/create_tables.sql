use library;	
CREATE TABLE customer(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50)
);

CREATE TABLE book(
	id INT NOT NULL AUTO_INCREMENT,
    bookName VARCHAR(50),
    isbn VARCHAR(50),
    customerId INT,
    genre VARCHAR(50),
    FOREIGN KEY (customerId) REFERENCES customer(id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE author(
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    age INT,
    PRIMARY KEY (id)
);

CREATE TABLE book_author(
	id INT NOT NULL AUTO_INCREMENT,
    bookId INT,
    authorId INT,
    FOREIGN KEY (bookId) REFERENCES book (id)  ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (authorId) REFERENCES author(id)  ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (id)
);


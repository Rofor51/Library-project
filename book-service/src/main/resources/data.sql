INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Let the right one in', '191', '2007-06-27','/images/right-one.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Harry Potter and the Cursed Child', '355', '2007-06-27','/images/cursed-child.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Harry Potter and the Deathly Hallows', '23', '2007-06-27','/images/deathly-hallows.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Harry Potter and the Philosophers Stone', '456', '2007-06-27','/images/philo.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Handling the Undead', '384', '2007-06-27','/images/handling-undead.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Let the Old Dreams Die', '384', '2007-06-27','/images/old-dreams.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('Little star', '384', '2007-06-27','/images/star.jpg',true);
INSERT INTO book (title, pages, date, imageLink,instore) VALUES ('I Am Behind You', '384', '2007-06-27','/images/behind-you.jpg',true);

INSERT INTO author (name, last_name) VALUES ('J.K', 'Rowling');
INSERT INTO author (name, last_name) VALUES ('Peter', 'Johansson');
INSERT INTO author (name, last_name) VALUES ('John', 'Lindqvist');



INSERT INTO author_book (book_id, author_id) VALUES (1,2);
INSERT INTO author_book (book_id, author_id) VALUES (2,1);
INSERT INTO author_book (book_id, author_id) VALUES (3,1);
INSERT INTO author_book (book_id, author_id) VALUES (4,1);
INSERT INTO author_book (book_id, author_id) VALUES (5,3);
INSERT INTO author_book (book_id, author_id) VALUES (6,3);
INSERT INTO author_book (book_id, author_id) VALUES (7,3);
INSERT INTO author_book (book_id, author_id) VALUES (8,3);
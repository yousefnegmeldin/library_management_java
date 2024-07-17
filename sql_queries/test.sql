SELECT * FROM books
WHERE id = (SELECT bookId FROM book_author WHERE authorId = ?)
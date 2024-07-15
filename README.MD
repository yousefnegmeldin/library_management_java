# Library Management System

---
## Features

- Retrieve books by authors
- Display all books
- Add books to library
- Remove books from library
- Borrow books as a customer from the library
- Return book borrowed as a customer

## Java Features Used

### Optionals
I used the optional type in the following function
```java
public Optional<List<Book>> retrieve(Author author)
```
Here, I return the optional data type denoting that the return type may be null if
there is no books found with that author name.

It may not be the most practical way to implement optionals,
but It was a good opportunity for practice.

### Stream API & Lambda Functions
Java stream API is very similar to the prebuilt `forEach map filter reduce` found in javascript.
The Lambda functions are exactly the same as arrow functions found in javascript too 
```()=> console.log("test!");```

I have implemented them in the following function
```java
public void displayBooks(){
    books.forEach(b->System.out.println("Book Name: "+b.getName() +", Book Author: "+ b.getAuthor().getFirstName() +" " +b.getAuthor().getLastName()+ ", Book Id: "+b.getBookId()));
}
```


---
## Abstract Classes
- Book
- Human
## Classes
- Customer
- Author
- FantasyBook
- NonFictionBook
- Library
- Main

### Abstraction
Abstraction is implemented in the Human and Book classes.

### Polymorphism
The books arraylist and the borrowed hashmap in the Library class use polymorphism.
`ArrayList<Book>` and `Hashmap<Book,Customer>`. Book here is an abstract class,
that can contain objects of more specific books such as FantastyBook.

### Inheritance
The Customer and Author classes both inherit from the Human class, and the FantasyBook
and NonFictionBook classes inherit from Book.

### Encapsulation
All attributes in each class are declared private, with setter and getter methods for
each attribute. Therefore, trying to access the attribute from outside its class will
not be allowed.
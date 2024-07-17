package database;

import models.Author;
import models.Book;
import models.FantasyBook;
import services.SQLService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class SeedDatabase {


    public static void main(String[] args) {
        SQLService sqlService = new SQLService();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src/database/google-10000-english.txt"))) {
            stream.forEach(words::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Stream<String> stream = Files.lines(Paths.get("src/database/first-names.txt"))) {
            stream.forEach(names::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i =0;i<1000;i++){
            int randomNumForFirstName =(int) Math.floor(Math.random()*4500);
            int randomNumForLastName =(int) Math.floor(Math.random()*4500);
            int randomNumForBookName1 =(int) Math.floor(Math.random()*10000);
            int randomNumForBookName2 =(int) Math.floor(Math.random()*10000);
            String isbn = ((int) Math.floor(Math.random()*2516788)) +"";
            int authorAge = (int) Math.floor(Math.random()*100);
            String authorFirstName = names.get(randomNumForFirstName);
            String authorLastName = names.get(randomNumForLastName);
            String bookFirstWord = words.get(randomNumForBookName1);
            String bookSecondWord = words.get(randomNumForBookName2);
            String bookName = bookFirstWord+ " "+ bookSecondWord;
            System.out.println(i);
            Book bookToAdd = new FantasyBook(bookName,isbn,"Fantasy");
            Author author1 = new Author(authorFirstName,authorLastName,authorAge);
            bookToAdd.setAuthor(author1);
            sqlService.addAuthorToDatabase(author1);
            sqlService.addBookToDatabase(bookToAdd);
        }
    }
}

package by.jrr;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void getAuthor() {
        Book book = new Book();
        book.setAuthor("Herbert Schildt");

        String expected = "Herbert Schildt";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

    @Test
    public void getBookTitle() {
        Book book = new Book();
        book.setBookTitle("Java: A Beginner's Guide");

        String expected = "Java: A Beginner's Guide";
        String actual = book.getBookTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfPages() {
        Book book = new Book();
        book.setNumberOfPages(816);

        int expected = 816;
        int actual = book.getNumberOfPages();
        assertEquals(expected, actual);
    }

   

    @Test
    public void testEqualsTrue() {
        Book firstBook = new Book();
        firstBook.setAuthor("Herbert Schildt");
        firstBook.setBookTitle("Java: A Beginner's Guide");
        firstBook.setNumberOfPages(816);

        Book secondBook = new Book();
        secondBook.setAuthor("Herbert Schildt");
        secondBook.setBookTitle("Java: A Beginner's Guide");
        secondBook.setNumberOfPages(816);

        boolean expected = true;
        boolean actual = firstBook.equals(secondBook);
        assertEquals(expected, actual);
    }
    @Test
    public void testEqualsFalse() {
        Book firstBook = new Book();
        firstBook.setAuthor("Herbert Schildt");
        firstBook.setBookTitle("Java: A Beginner's Guide.");
        firstBook.setNumberOfPages(816);

        Book secondBook = new Book();
        secondBook.setAuthor("Bruce Eckel");
        secondBook.setBookTitle("Thinking in Java");
        secondBook.setNumberOfPages(1168);

        boolean expected = false;
        boolean actual = firstBook.equals(secondBook);
        assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        Book book = new Book();
        book.setAuthor("Bruce Eckel");
        book.setBookTitle("Thinking in Java");
        book.setNumberOfPages(1168);

        Integer expected = 360005213;
        Integer actual = book.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        Book book = new Book();
        book.setAuthor("Bruce Eckel");
        book.setBookTitle("Thinking in Java");
        book.setNumberOfPages(1168);

        String expected = "Book{author='Bruce Eckel', bookTitle='Thinking in Java', numberOfPages=1168}";
        String actual = book.toString();
        assertEquals(expected, actual);
    }
}
package by.jrr;

import java.util.Objects;

public class Book {
    private String author;
    private String bookTitle;
    private int numberOfPages;

    
    public Book() {
        // no args constructor
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages &&
                author.equals(book.author) &&
                bookTitle.equals(book.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, bookTitle, numberOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}

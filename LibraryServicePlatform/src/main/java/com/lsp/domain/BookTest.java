package com.lsp.domain;

public class BookTest {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String bookType;
    private String bookHot;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookHot() {
        return bookHot;
    }

    public void setBookHot(String bookHot) {
        this.bookHot = bookHot;
    }

    @Override
    public String toString() {
        return "BookTest{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookType='" + bookType + '\'' +
                ", bookHot='" + bookHot + '\'' +
                '}';
    }
}

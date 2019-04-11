package com.lsp.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class LoadBook {
    private String identifier;
    private String bookId;
    private Timestamp borrowTime;   //借书时间
    private Timestamp returnTime;  //还书时间
    private Timestamp term;     //还书期限

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public Timestamp getTerm() {
        return term;
    }

    public void setTerm(Timestamp term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "LoadBook{" +
                "identifier='" + identifier + '\'' +
                ", bookId='" + bookId + '\'' +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                ", term=" + term +
                '}';
    }
}

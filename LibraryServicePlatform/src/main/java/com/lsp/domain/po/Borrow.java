package com.lsp.domain.po;

public class Borrow {
    private int borrowId;
    private String bookId;
    private String userId;
    private String borrowTime;
    private String term;
    private String returnTime;
    private int status;          //是否归还书籍

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowTime='" + borrowTime + '\'' +
                ", term='" + term + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", status=" + status +
                '}';
    }
}

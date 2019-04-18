package com.lsp.domain.vo;

public class SetBookStatus {
    private String bookId;
    private int status;

    public String getBookIdId() {
        return bookId;
    }

    public void setBookIdId(String bId) {
        this.bookId = bId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SetBookStatus{" +
                "bId='" + bookId + '\'' +
                ", status=" + status +
                '}';
    }
}

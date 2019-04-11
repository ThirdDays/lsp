package com.lsp.domain;

/*
    书类
 */
public class Book {
    private String bId;
    private String bName;
    private String author;
    private String type;
    private int hot;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", hot=" + hot +
                '}';
    }
}

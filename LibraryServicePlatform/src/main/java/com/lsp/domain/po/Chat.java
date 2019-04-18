package com.lsp.domain.po;

public class Chat {
    private int chatId;
    private String oneSide;
    private String anotherSide;
    private String context;
    private String chatTime;

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getOneSide() {
        return oneSide;
    }

    public void setOneSide(String oneSide) {
        this.oneSide = oneSide;
    }

    public String getAnotherSide() {
        return anotherSide;
    }

    public void setAnotherSide(String anotherSide) {
        this.anotherSide = anotherSide;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getChatTime() {
        return chatTime;
    }

    public void setChatTime(String chatTime) {
        this.chatTime = chatTime;
    }
}

package com.lsp.domain.po;

public class LibAdvice {
    private int adviceId;
    private String content;
    private String time;

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LibAdvice{" +
                "adviceId=" + adviceId +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

package com.lsp.domain.vo;

public class SetBookStatus {
    private String bId;
    private int status;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
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
                "bId='" + bId + '\'' +
                ", status=" + status +
                '}';
    }
}

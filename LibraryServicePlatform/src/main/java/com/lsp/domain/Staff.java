package com.lsp.domain;

/*
    教职工类
 */
public class Staff{
    private String staId;
    private String staName;
    private String passwords;

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staId='" + staId + '\'' +
                ", staName='" + staName + '\'' +
                ", passwords='" + passwords + '\'' +
                '}';
    }
}

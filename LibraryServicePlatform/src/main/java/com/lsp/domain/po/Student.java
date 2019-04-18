package com.lsp.domain.po;

public class Student {
    private String stuId;
    private String stuName;
    private String passwords;
    private float balances;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public float getBalances() {
        return balances;
    }

    public void setBalances(float balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", balances=" + balances +
                '}';
    }
}

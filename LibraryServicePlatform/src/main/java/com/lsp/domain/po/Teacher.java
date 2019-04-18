package com.lsp.domain.po;

public class Teacher {
    private String teachId;
    private String teachName;
    private String passwords;
    private float balances;

    public String getTeachId() {
        return teachId;
    }

    public void setTeachId(String teachId) {
        this.teachId = teachId;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
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
        return "Teacher{" +
                "teachId='" + teachId + '\'' +
                ", teachName='" + teachName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", balances=" + balances +
                '}';
    }
}

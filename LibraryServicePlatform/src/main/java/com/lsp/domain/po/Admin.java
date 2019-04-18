package com.lsp.domain.po;

public class Admin {
    private String adminId;
    private String adminName;
    private String passwords;
    private float balances;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", balances=" + balances +
                '}';
    }
}

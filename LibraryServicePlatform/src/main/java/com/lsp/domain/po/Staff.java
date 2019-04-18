package com.lsp.domain.po;

public class Staff {
    private String staffId;
    private String staffName;
    private String passwords;
    private String section;
    private float balances;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public float getBalances() {
        return balances;
    }

    public void setBalances(float balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", section='" + section + '\'' +
                ", balances=" + balances +
                '}';
    }
}

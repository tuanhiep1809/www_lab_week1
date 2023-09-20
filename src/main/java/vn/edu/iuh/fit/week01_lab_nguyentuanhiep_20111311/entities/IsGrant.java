package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities;

public enum IsGrant {
    //is_grant nhận giá trị 0-diasable, 1-enable.)
    DISABLE(0), ENABLE(1);
    private int value;
    IsGrant(int value) {
        this.value = value;
    }
    public String getIsGrant() {
        if (value == 0) {
            return "Disable";
        }
        return "Enable";
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities;

public enum Status {
    ACTIVE(1),
    DEACTIVE(0),
    REMOVE(-1);


    private int status;


    Status(int s) {
        status = s;
    }

    public int getStatus() {

         return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }
}

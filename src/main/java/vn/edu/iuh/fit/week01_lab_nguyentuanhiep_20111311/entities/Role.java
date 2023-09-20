package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities;

public class Role {
    private String role_id;
    private String role_name;
    private String decscription;
    private  Status status;

    public Role(String role_id, String role_name, String decscription, Status status) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.decscription = decscription;
        this.status = status;
    }

    public Role() {

    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDecscription() {
        return decscription;
    }

    public void setDecscription(String decscription) {
        this.decscription = decscription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", decscription='" + decscription + '\'' +
                ", status=" + status +
                '}';
    }
}

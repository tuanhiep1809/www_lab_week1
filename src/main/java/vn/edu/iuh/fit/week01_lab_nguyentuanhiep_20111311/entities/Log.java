package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities;

import java.sql.Date;

public class Log {
    private int id;
    private String account_id;
    private Date login_time;
    private Date loguot_time;
    private String notes;

    public Log() {
    }

    public Log(int id, String account_id, Date login_time, Date loguot_time, String notes) {
        this.id = id;
        this.account_id = account_id;
        this.login_time = login_time;
        this.loguot_time = loguot_time;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLoguot_time() {
        return loguot_time;
    }

    public void setLoguot_time(Date loguot_time) {
        this.loguot_time = loguot_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", loguot_time=" + loguot_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}

package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.repositories;

import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Status;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.services.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositories {
    Connection connection;
    PreparedStatement pretatement = null;

    public AccountRepositories() {
       connection = ConnectionDB.getInstance().getConnection();
    }

    // lấy thông tin  tất cả tài khoản
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<Account>();
        try {

            pretatement = connection.prepareStatement("SELECT * FROM account");
            ResultSet resultSet = pretatement.executeQuery();
            while (resultSet.next()) {

                Account account = new Account(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        Status.values()[resultSet.getInt(6)]);
                list.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
    public boolean kiemTraAdmin (String accountID) throws SQLException {
        String sql = "SELECT * FROM grant_access WHERE account_id = ? AND is_grant = 1 AND role_id IN (SELECT role_id FROM role WHERE role_name = 'administrator')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, accountID);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }
    public boolean login (String accountID, String password) throws SQLException {

        String sql = "SELECT * FROM account\n" +
                "WHERE account_id = ? AND PASSWORD =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,accountID);
        statement.setString(2,password);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

}

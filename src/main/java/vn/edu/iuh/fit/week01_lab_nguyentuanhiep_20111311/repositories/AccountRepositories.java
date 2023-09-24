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
    public boolean insert(Account account) throws SQLException {
        String sql = "INSERT account VALUE(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getAccount_id());
        statement.setString(2, account.getFull_name());
        statement.setString(3, account.getPassword());
        statement.setString(4, account.getEmail());
        statement.setString(5, account.getPhone());
        statement.setInt(6, account.getStatus().getStatus());

        return statement.executeUpdate() > 0;

    }

    public boolean update(Account account) throws SQLException {
        String sql = "UPDATE account\n" +
                "SET full_name=?,password = ?, email = ?, phone = ?, status = ? \n" +
                "WHERE account_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getFull_name());
        statement.setString(2, account.getPassword());
        statement.setString(3, account.getEmail());
        statement.setString(4, account.getPhone());
        statement.setInt(5, account.getStatus().getStatus());
        statement.setString(6, account.getAccount_id());

        return statement.executeUpdate() > 0;

    }
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
                        getStatusFromInt(resultSet.getInt(6)));
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
    public Account findAccountByID (String id){
        Account account = null;
        try {
            pretatement = connection.prepareStatement("SELECT * FROM account WHERE account_id = ?");
            pretatement.setString(1,id);
            ResultSet resultSet = pretatement.executeQuery();
            while (resultSet.next()){
                account = new Account(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        getStatusFromInt(resultSet.getInt(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
    private Status getStatusFromInt(int intValue) {
        switch (intValue) {
            case 0:
                return Status.DEACTIVE;
            case 1:
                return Status.ACTIVE;
            case -1:
                return Status.REMOVE;
            default:
                throw new IllegalArgumentException("Giá trị enum không hợp lệ: " + intValue);
        }
    }
//    private int getStatusFromString(String intValue) {
//        switch (intValue) {
//            case "DEACTIVE":
//                return 0;
//            case "ACTIVE":
//                return 1;
//            case "REMOVE":
//                return -1;
//            default:
//                throw new IllegalArgumentException("Giá trị enum không hợp lệ: " + intValue);
//        }
//    }
    public boolean delete(String id) throws SQLException {
        String sql =  "UPDATE account\n" +
                "SET `status` = -1\n" +
                "WHERE account_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        return statement.executeUpdate() > 0;

    }
}

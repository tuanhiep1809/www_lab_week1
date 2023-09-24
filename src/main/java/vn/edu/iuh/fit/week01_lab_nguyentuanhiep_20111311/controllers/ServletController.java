package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Status;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.repositories.AccountRepositories;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/ControlServlet", "/Login", "/dashboard"})

public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountRepositories accountRepositories = new AccountRepositories();
    ;

    public ServletController() {

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                try {
                    Login(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Delete":
                try {
                    Delete(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "add":
                try {
                    Add(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "Update":
                try {
                    Update(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);

    }


        protected void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //lấy id từ trang dashboard.jsp
        String accountIDUpdate = req.getParameter("account_idUpdate");
        accountIDUpdate = accountIDUpdate.trim();
        System.out.println(accountIDUpdate);

        int s = Integer.parseInt(req.getParameter("StatusUpdate"));
        Status status = getStatusFromInt(s) ;
        Account account = new Account(accountIDUpdate, req.getParameter("FullnameUpdate"), req.getParameter("PasswordUpdate"), req.getParameter("EmailUpdate"), req.getParameter("PhoneUpdate"),status  );
       System.out.println(account);
        accountRepositories.update(account);
        String kiemTraAdmin = "admin";
        req.setAttribute("kiemTraAdmin", kiemTraAdmin);
        String id = req.getParameter("account_id");
        List<Account> list = accountRepositories.getAllAccount();
        req.setAttribute("list", list);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }
    protected void Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int s = Integer.parseInt(req.getParameter("StatusAdd"));
        Status status = getStatusFromInt(s) ;

        Account account = new Account(req.getParameter("account_idAdd"), req.getParameter("FullnameAdd"), req.getParameter("PasswordAdd"), req.getParameter("EmailAdd"), req.getParameter("PhoneAdd"),status  );
        accountRepositories.insert(account);
        String kiemTraAdmin = "admin";
        req.setAttribute("kiemTraAdmin", kiemTraAdmin);
        String id = req.getParameter("account_id");
        List<Account> list = accountRepositories.getAllAccount();
        req.setAttribute("list", list);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);


    }
    protected void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //lấy id từ trang dashboard.jsp
        String accountID = req.getParameter("id");
        accountRepositories.delete(accountID);
        String kiemTraAdmin = "admin";
        req.setAttribute("kiemTraAdmin", kiemTraAdmin);
        String id = req.getParameter("account_id");
        List<Account> list = accountRepositories.getAllAccount();
        req.setAttribute("list", list);
        req.setAttribute("id", id);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);


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

    protected void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        boolean login = accountRepositories.login(req.getParameter("account_id"), req.getParameter("password"));

        String id = req.getParameter("account_id");
        String kiemTraAdmin = "";
        if (login) {
            boolean isAdmin = accountRepositories.kiemTraAdmin(req.getParameter("account_id"));

            if (isAdmin) {
                List<Account> list = accountRepositories.getAllAccount();
                req.setAttribute("list", list);
                kiemTraAdmin = "admin";
                req.setAttribute("kiemTraAdmin", kiemTraAdmin);
                req.setAttribute("id", id);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

            } else {
                Account AccountUser = accountRepositories.findAccountByID(req.getParameter("account_id"));
                req.setAttribute("AccountUser", AccountUser);
                kiemTraAdmin = "user";
                req.setAttribute("kiemTraAdmin", kiemTraAdmin);
                req.setAttribute("id", id);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

            }

        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
            // Chuyển hướng người dùng đến trang đăng nhập
            req.getRequestDispatcher("Login.jsp").forward(req, resp);


        }


    }
}

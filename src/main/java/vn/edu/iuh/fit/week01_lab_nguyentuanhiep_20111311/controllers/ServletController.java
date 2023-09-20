package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.entities.Account;
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
                    throw new RuntimeException(e);
                }
                break;

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    protected void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
//        out.println("var xacNhan = confirm('Bạn có chắc chắn muốn xóa không?');");
//        out.println("if (xacNhan) { '<%   boolean delete= accountRepositories.delete(req.getParameter(\"account_id\")); if (delete){  List<Account> list = accountRepositories.getAllAccount();req.setAttribute(\"list\", list);req.getRequestDispatcher(\"dashboard.jsp\").forward(req, resp);%>'");
//        out.println("    alert('Bạn đã chọn Yes.');");
//        out.println("} else {");
//        out.println("    alert('Bạn đã chọn No.');");
//        out.println("}");
        out.println("alert('Bạn đã chọn No.');");
        out.println("</script>");

    }

    protected void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        boolean login = accountRepositories.login(req.getParameter("account_id"), req.getParameter("password"));
        PrintWriter out = resp.getWriter();
        System.out.println("a" + req.getParameter("account_id") + "b" + req.getParameter("password"));
        String kiemTraAdmin = "";
        if (login) {
            boolean isAdmin = accountRepositories.kiemTraAdmin(req.getParameter("account_id"));

            if (isAdmin) {
                List<Account> list = accountRepositories.getAllAccount();
                req.setAttribute("list", list);
                kiemTraAdmin = "admin";
                req.setAttribute("kiemTraAdmin", kiemTraAdmin);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

            } else {
                Account AccountUser = accountRepositories.findAccountByID(req.getParameter("account_id"));
                req.setAttribute("AccountUser", AccountUser);
                kiemTraAdmin = "user";
                req.setAttribute("kiemTraAdmin", kiemTraAdmin);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            }
        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Tên đăng nhập hoặc mật khẩu không chính xác');");
            out.println("</script>");

        }

    }
}

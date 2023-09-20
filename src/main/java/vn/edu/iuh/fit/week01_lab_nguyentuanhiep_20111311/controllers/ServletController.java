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

@WebServlet(urlPatterns = "/ControlServlet")

public class ServletController extends HttpServlet {
private static final long serialVersionUID = 1L;
private AccountRepositories accountRepositories = new AccountRepositories();;

public ServletController() {

}


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    switch (action){
        case "login":
            try {
                Login(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            break;

    }
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


}
protected void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
   boolean login = accountRepositories.login(req.getParameter("account_id"),req.getParameter("password"));
   PrintWriter out1 = resp.getWriter();
    List<Account> list = accountRepositories.getAllAccount();
    req.setAttribute("list", list);
//        System.out.println("ádas"+list.size());
//        RequestDispatcher view = req.getRequestDispatcher("view.jsp");
//
//        view.forward(req, resp);
   if (login){

    out1.println("");
        System.out.println("true");
      req.getRequestDispatcher("view.jsp").forward(req,resp);
      resp.sendRedirect("view");
   }
   else {

       PrintWriter out = resp.getWriter();
       out.println("<h1> hiep</h1>");
       System.out.println("false");

   }

}
}

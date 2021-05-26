package com.max.restApp.views;

import com.max.restApp.controllers.AccountController;
import com.max.restApp.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/accounts")
public class Accounts extends HttpServlet {
    AccountController controller = new AccountController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = controller.getAll();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Id</td>");
        writer.println("<td>Email</td>");
        writer.println("<td>Codeword</td>");
        writer.println("<td>AccountStatus()</td>");
        writer.println("<td>User id</td>");
        writer.println("</tr>");
        for (var account : accounts) {
            writer.println("<tr>");
            writer.println("<td>" + account.getId() + "</td>");
            writer.println("<td>" + account.getEmail() + "</td>");
            writer.println("<td>" + account.getCodeword() + "</td>");
            writer.println("<td>" + account.getAccountStatus() + "</td>");
            try{
                writer.println("<td>" + account.getUser().getId() + "</td>");
            }catch (NullPointerException e){
                writer.println("<td>" + "null" + "</td>");
            }
            writer.println("<tr>");
        }
        writer.println("</table><br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.save(convertRequestParametersToObject(req));
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = convertRequestParametersToObject(req);
        account.setId(Integer.parseInt(req.getParameter("id")));
        controller.update(account);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.deleteById(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }

    private Account convertRequestParametersToObject(HttpServletRequest req) {
        Account account = new Account();
        account.setEmail(req.getParameter("email"));
        account.setCodeword(req.getParameter("codeword"));
        account.setAccountStatus(AccountStatus.valueOf(req.getParameter("accountStatus")));
        User user = new User();
        try {
            user.setId(Integer.parseInt(req.getParameter("userId")));
        }finally {
            account.setUser(user);
        }
        return account;
    }
}

package com.max.restApp.views;

import com.max.restApp.controllers.UserController;
import com.max.restApp.models.Account;
import com.max.restApp.models.Event;
import com.max.restApp.models.File;
import com.max.restApp.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class Users extends HttpServlet {
    UserController controller = new UserController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = controller.getAll();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Id</td>");
        writer.println("<td>First name</td>");
        writer.println("<td>Last name</td>");
        writer.println("<td>Account id</td>");
        writer.println("</tr>");
        for (var user : users) {
            writer.println("<tr>");
            writer.println("<td>" + user.getId() + "</td>");
            writer.println("<td>" + user.getFirstName() + "</td>");
            writer.println("<td>" + user.getLastName() + "</td>");
            try{
                writer.println("<td>" + user.getAccount().getId() + "</td>");
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
        User user = convertRequestParametersToObject(req);
        user.setId(Integer.parseInt(req.getParameter("id")));
        controller.update(user);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.deleteById(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }

    private User convertRequestParametersToObject(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        Account account = new Account();
        try {
            account.setId(Integer.parseInt(req.getParameter("accountId")));
        }finally {
            user.setAccount(account);
        }
        return user;
    }
}

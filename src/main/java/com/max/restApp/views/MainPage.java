package com.max.restApp.views;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/main")
public class MainPage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter messageWriter = response.getWriter();
        messageWriter.print("<html><body>");
        messageWriter.println("<h1>" + "mainPage" + "<h1>");
        messageWriter.print("</body></html>");
        messageWriter.close();
    }
}

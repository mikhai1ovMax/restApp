package com.max.restApp.views;

import com.max.restApp.controllers.FileController;
import com.max.restApp.models.File;
import com.max.restApp.models.FileStatus;
import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/files")
public class Files extends HttpServlet {
    FileController controller = new FileController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<File> files = controller.getAll();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
            writer.println("<tr>");
                writer.println("<td>id</td>");
                writer.println("<td>text</td>");
                writer.println("<td>file status</td>");
                writer.println("<td>time of creation</td>");
                writer.println("<td>user id</td>");
            writer.println("</tr>");
            for (var file : files) {
                writer.println("<tr>");
                    writer.println("<td>" + file.getId() + "</td>");
                    writer.println("<td>" + file.getText() + "</td>");
                    writer.println("<td>" + file.getFileStatus() + "</td>");
                    writer.println("<td>" + file.getCreated() + "</td>");
                    writer.println("<td>" + file.getUser() + "</td>");
                writer.println("<tr>");
            }
        writer.println("</table>");
    }
}

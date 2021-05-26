package com.max.restApp.views;

import com.max.restApp.controllers.FileController;
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

@WebServlet("/files")
public class
Files extends HttpServlet {
    FileController controller = new FileController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<File> files = controller.getAll();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
            writer.println("<tr>");
                writer.println("<td>id</td>");
                writer.println("<td>text</td>");
                writer.println("<td>format</td>");
                writer.println("<td>file status</td>");
                writer.println("<td>time of creation</td>");
                writer.println("<td>user id</td>");
            writer.println("</tr>");
            for (var file : files) {
                writer.println("<tr>");
                    writer.println("<td>" + file.getId() + "</td>");
                    writer.println("<td>" + file.getText() + "</td>");
                    writer.println("<td>" + file.getFormat() + "</td>");
                    writer.println("<td>" + file.getFileStatus() + "</td>");
                    writer.println("<td>" + file.getCreated() + "</td>");
                    try{
                        writer.println("<td>" + file.getUser().getId() + "</td>");
                    }catch (NullPointerException e){
                        writer.println("<td>" + "null" + "</td>");
                    }
                writer.println("<tr>");
            }
        writer.println("</table><br>");

        writer.println("<p>New file:</p>");
        writer.println("<form method=\"POST\">");
            writer.println("<label for=\"text\">Text</label>");
            writer.println("<input name=\"text\" id=\"text\"><br>");
            writer.println("<label for=\"format\">File format</label>");
            writer.println("<input name=\"format\" id=\"format\"><br>");
            writer.println("<label for=\"userId\">User id</label>");
            writer.println("<input name=\"userId\" id=\"userId\" ><br>");
            writer.println("<button>save</button>");
        writer.println("</form><br>");

        writer.println("<p>Edit file:</p>");
        writer.println("<form method=\"PUT\">");
        writer.println("<label for=\"id\">Id</label>");
        writer.println("<input name=\"id\" id=\"id\"><br>");
        writer.println("<label for=\"text\">Text</label>");
        writer.println("<input name=\"text\" id=\"text\"><br>");
        writer.println("<label for=\"format\">File format</label>");
        writer.println("<input name=\"format\" id=\"format\"><br>");
        writer.println("<label for=\"userId\">User id</label>");
        writer.println("<input name=\"userId\" id=\"userId\"><br>");
        writer.println("<button>update</button>");
        writer.println("</form><br>");

        writer.println("<p>Delete file:</p>");
        writer.println("<form method=\"DELETE\">");
        writer.println("<label for=\"id\">Id</label>");
        writer.println("<input name=\"id\" id=\"id\"><br>");
        writer.println("<button>delete</button>");
        writer.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.save(convertRequestParametersToObject(req));
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = convertRequestParametersToObject(req);
        file.setId(Integer.parseInt(req.getParameter("id")));
        controller.update(file);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.parseInt(req.getParameter("id"));
        controller.deleteById(i);
        doGet(req, resp);
    }

    private File convertRequestParametersToObject(HttpServletRequest req) {
        File file = new File();
        file.setText(req.getParameter("text"));
        file.setFormat(req.getParameter("format"));
        User user = new User();
        try {
            user.setId(Integer.parseInt(req.getParameter("userId")));
        }finally {
        file.setUser(user);
        }
        return file;
    }
}

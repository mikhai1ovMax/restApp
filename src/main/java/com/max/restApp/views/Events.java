package com.max.restApp.views;

import com.max.restApp.controllers.EventController;
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

@WebServlet("/events")
public class Events extends HttpServlet {
    EventController controller = new EventController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> events = controller.getAll();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Id</td>");
        writer.println("<td>Name</td>");
        writer.println("<td>Description</td>");
        writer.println("<td>user id</td>");
        writer.println("</tr>");
        for (var event : events) {
            writer.println("<tr>");
            writer.println("<td>" + event.getId() + "</td>");
            writer.println("<td>" + event.getName() + "</td>");
            writer.println("<td>" + event.getDescription() + "</td>");

            try{
                writer.println("<td>" + event.getUser().getId() + "</td>");
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
        Event event = convertRequestParametersToObject(req);
        event.setId(Integer.parseInt(req.getParameter("id")));
        controller.update(event);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.deleteById(Integer.parseInt(req.getParameter("id")));
        doGet(req, resp);
    }

    private Event convertRequestParametersToObject(HttpServletRequest req) {
        Event event = new Event();
        event.setName(req.getParameter("name"));
        event.setDescription(req.getParameter("description"));
        User user = new User();
        try {
            user.setId(Integer.parseInt(req.getParameter("userId")));
        }finally {
            event.setUser(user);
        }
        return event;
    }
}

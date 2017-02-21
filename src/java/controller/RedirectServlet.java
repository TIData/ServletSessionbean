/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bram
 */
@WebServlet(name = "RedirectServlet", urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String location = request.getParameter("page");

        if (location != null && location.equals("hello")) {
            response.sendRedirect("hello");
            return;
         } 
        HttpSession session = request.getSession(true);
        Integer number = (Integer)session.getAttribute("number");
        if(number == null){
            number = -1;
        }
        
        session.setAttribute("number", ++number);
        response.setContentType("text/html");
        // send HTML page to client
        // start HTML document
        try (PrintWriter out = response.getWriter()) {
            // send HTML page to client

            // start HTML document
            out.println("<!DOCTYPE html>");
            out.println("<html>");

            // head section of document
            out.println("<head>");
            out.println("<title>Welcome to Sessions</title>");
            out.println("</head>");

            // body section of document
            out.println("<body>");
            
            out.println(
                    "This " + (session.isNew() ? "is" : "is not")
                    + " a new session<br>");

            

            out.println("<p>Number: " +number +"</p>");
            out.println("</body>");

            // end HTML document
            out.println("</html>");
        
        }
    }
}
        



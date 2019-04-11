/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author May
 */
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("loginpage.html?InvalidInput");
        } else {
            
            String loggedIn = (String) session.getAttribute("UserLoggedIn");
            String userName = (String) session.getAttribute("Username");
            String passWord = (String) session.getAttribute("Password");

            PrintWriter writer = resp.getWriter();
            writer.println("Welcome Servlet Page");
            writer.println("Username: "+userName);
            writer.println("Password: "+passWord);
        }
    }


}

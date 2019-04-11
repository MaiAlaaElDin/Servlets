/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import DAOImplementation.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author May
 */
public class LoginDBServlet extends HttpServlet {

    UserDAO userdao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        //String queryString = req.getQueryString();

        boolean userValid = userdao.validateUserLogin(username, password);
        RequestDispatcher myRequestDispatcher = req.getRequestDispatcher("welcomepage");

        if (userValid) {
            req.setAttribute("user", username);
            req.setAttribute("pass", password);
            myRequestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("loginpage.html?InvalidInput");

        }

    }

}

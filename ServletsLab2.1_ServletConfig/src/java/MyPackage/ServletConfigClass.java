/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author May
 */
public class ServletConfigClass implements Servlet {
 
    ServletConfig myconfig; 
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        myconfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //getting servlet config parameters
        String value = myconfig.getInitParameter("Mai");
        PrintWriter out = res.getWriter();
        out.println("Parameter Name: Mai");
        out.println("Parameter Value: "+value);
        
        //getting servlet context parameters
        ServletContext application=myconfig.getServletContext(); 
        String contextValue = application.getInitParameter("Hello");
        out.println("Parameter Name: Hello");
        out.println("Parameter Value: "+contextValue);
        
        //setting servlet context attributes
        application.setAttribute("Android", "IOS");
        
    }

    @Override
    public String getServletInfo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

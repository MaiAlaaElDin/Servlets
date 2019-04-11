/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MimeType;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author May
 */
public class MimeTypeServlet extends GenericServlet {

    ServletConfig myConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("image/png");
        ServletOutputStream outputStream = res.getOutputStream(); //instead of getWriter()
        File file = new File("C:\\Users\\May\\Desktop\\femalepp2.png");
        FileInputStream fileReader = new FileInputStream(file);

        byte[] myCharArray = new byte[1024];
        int data;
        while ((data = fileReader.read(myCharArray)) != -1) 
        {
            outputStream.write(myCharArray);  
        }

    }

}

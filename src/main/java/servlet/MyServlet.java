/**
 * Copyright (C), 2015-2017
 * FileName: MyServlet
 * Author:   qianwenjun
 * Date:     2017/11/9 12:49
 * Description: wanyiwan
 */
package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 〈wanyiwan〉
 *
 * @author qianwenjun
 * @create 2017/11/9
 * @since 1.0.0
 */
public class MyServlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String messeage = "a simple example";

        out.println("<HTML><BODY>");
        out.println("<H1>" + messeage + "</H1>");

        out.println("</BODY></HTML>");
        out.close();


    }

}
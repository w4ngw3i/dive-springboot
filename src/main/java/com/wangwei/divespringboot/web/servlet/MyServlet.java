package com.wangwei.divespringboot.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther wangwei
 * @Date 2018/11/12 3:45 PM
 */
@WebServlet(urlPatterns = "/my/servlet", asyncSupported = true)
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 开启异步
         */
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(() -> {
            try {
                resp.getWriter().println("laoda hello");

                //触发异步完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });




    }
}

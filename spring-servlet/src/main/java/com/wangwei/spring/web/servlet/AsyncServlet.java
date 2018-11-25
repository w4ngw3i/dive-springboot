package com.wangwei.spring.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

/**
 * @Auther wangwei
 * @Date 2018/11/25 9:11 PM
 */
@WebServlet(
        asyncSupported = true,
        name = "asyncServlet",
        urlPatterns = "/asyncServlet"
)
public class AsyncServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

        if (request.isAsyncSupported()){
            AsyncContext asyncContext = request.startAsync();

            asyncContext.addListener(new AsyncListener() {

                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    HttpServletResponse suppliedResponse = (HttpServletResponse) event.getSuppliedResponse();
                    suppliedResponse.setStatus(SC_SERVICE_UNAVAILABLE);
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("开始执行");
                }
            });
        }


        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write("老大, 您好！");
    }


    private static void println(Object obj){
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName +"]:" + obj);
    }
}

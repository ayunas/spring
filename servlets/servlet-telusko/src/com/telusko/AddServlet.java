package com.telusko;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add", name = "AddServlet")
public class AddServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		System.out.println("num 1 is " + num1);
		System.out.println("num 2 is " + num2);
		int sum = num1 + num2;
		System.out.println("the sum is : " + sum);
//		res.getWriter().println("result is : " + sum);

		req.setAttribute("sum", sum);
//		RequestDispatcher reqDisp = req.getRequestDispatcher("/square");
//		reqDisp.forward(req,res);

		res.sendRedirect("square?param1=9");  //the url pattern, do not use the /. it is not recognized. known as URL rewriting

	}
}

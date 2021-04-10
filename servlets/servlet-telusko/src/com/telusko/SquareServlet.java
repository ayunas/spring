package com.telusko;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/square")
public class SquareServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		System.out.println("Square Servlet called");
		int kVal = Integer.parseInt(req.getParameter("param1"));
		System.out.println("kVal = " + kVal);


//		PrintWriter out = res.getWriter();
//		int num = Integer.parseInt(req.getParameter("num1"));
//		int power = Integer.parseInt(req.getParameter("num2"));
//
//		double poweredNum = Math.pow(num,power);
//		out.println("the powered number is : " + poweredNum);
	}


}

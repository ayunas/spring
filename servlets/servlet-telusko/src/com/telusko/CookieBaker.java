package com.telusko;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie")
public class CookieBaker extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//get num1 parameter
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		int sum = num1 + num2;

		Cookie cookie = new Cookie("sum", sum + "");

		res.addCookie(cookie);
		res.getWriter().println("k = " + sum);
		System.out.println("cookie : " + cookie);
		res.sendRedirect("eat");

	}
}

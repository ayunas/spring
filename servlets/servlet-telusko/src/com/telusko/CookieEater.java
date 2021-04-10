package com.telusko;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/eat")
public class CookieEater extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("in the CookieEater Servlet");

		int k = 0;
		Cookie[] cookies = req.getCookies();
		String cookieList = Arrays.toString(cookies);
		System.out.println(cookieList);

		for (Cookie c : cookies) {
			if (c.getName().equals("sum")) {
				k = Integer.parseInt(c.getValue());
			}
		}

		k = (int) Math.pow(k, 2);
		PrintWriter out = res.getWriter();
		out.println("Cookie computed result is : " + k);


	}
}


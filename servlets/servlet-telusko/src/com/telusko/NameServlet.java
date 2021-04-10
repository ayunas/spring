package com.telusko;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/name/*")
public class NameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getPathInfo().substring(1);
//		System.out.println(name);
		System.out.println("reached the name servlet");


//		Enumeration<String>	getParameterNames()
//Returns an Enumeration of String objects containing the names of the parameters contained in this request.
//String[]	getParameterValues(String name)

		Enumeration<String> parameters = req.getParameterNames();
		parameters.asIterator().forEachRemaining(s -> System.out.println(s));

		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		PrintWriter out = resp.getWriter();
		out.println("The full name is : " + firstName + " " + lastName);
	}
}

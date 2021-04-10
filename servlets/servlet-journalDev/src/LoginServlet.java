import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	private final String userID = "ayunas";
	private final String password = "secret";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		System.out.println("username " + user);
		System.out.println("password " + pass);
		System.out.println("required username and password" + userID + " " + password);

		if (userID.equals(user) && password.equals(pass)) {
			Cookie loginCookie = new Cookie("user", user);
			loginCookie.setMaxAge(30 * 60); //set cookie to expire in 30 minutes
			res.addCookie(loginCookie);
			res.sendRedirect("index.jsp");  //LoginSuccess.jsp is not recognized for some reason.
		} else {
			RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = res.getWriter();
			out.println("<font color=red>Incorrect username or password</font>");
			reqDisp.include(req, res);
		}
	}
}


//https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting#servlet-session

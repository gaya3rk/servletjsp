

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispatcher4
 */
public class Dispatcher4 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Dispatcher4 servlet");
		String a=(String)request.getAttribute("Employeenumber");
		String b=(String)request.getAttribute("Empname");
		String c=(String)request.getAttribute("Salary");
		String d=(String)request.getAttribute("Depart");
		out.println("<h1> EmpDetails:" +a+" "+b + " " +c+" " +d);
	}

}

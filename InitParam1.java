
//import java.util.*;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParam1 extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	out.println("<h1>Init Paramaters names are:");
	Enumeration enumeration=getServletContext().getInitParameterNames();
	while(enumeration.hasMoreElements())
	{
		out.println(enumeration.nextElement()+" ");
	}
	ServletContext con1=getServletContext();
	out.println("<h1>Company:" +con1.getInitParameter("Company"));
	out.println("Venue:"+con1.getInitParameter("Venue"));
	out.println("Training:" +con1.getInitParameter("Training"));
	
	out.println("<h1>Company:" +getServletContext().getInitParameter("Company"));
	out.println("Venue:"+getServletContext().getInitParameter("Venue"));
	out.println("Training:"+getServletContext().getInitParameter("Training"));
	try
	{
		String url=getServletContext().getInitParameter("url");
		String usr=getServletContext().getInitParameter("User");
		String pass=getServletContext().getInitParameter("Password");
		Class.forName(getServletContext().getInitParameter("driver"));
		Connection con=DriverManager.getConnection("url","usr","pass");
		System.out.println("Connecting");
		
	}
	catch(ClassNotFoundException | SQLException cf)
	{
		System.out.println(cf);
	}
	}
	}



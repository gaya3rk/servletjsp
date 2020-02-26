

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class assignment1 extends HttpServlet 
{
	boolean x=false;
	Connection con=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name1=request.getParameter("username");
		String  password=request.getParameter("password");
		request.setAttribute("username",name1);
		request.setAttribute("password",password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gaya3","root","root");
			PreparedStatement ps=con.prepareStatement("select * from login");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String s=rs.getString("password");
				String s2=rs.getString("username");
				if((s.equals(password))&&(s2.equals(name1)))
				{
					x=true;
				}
			}
		}
		catch(SQLException | ClassNotFoundException se) 
		{System.out.println(se);}

		if(x==true)
		{
			//out.println("Success");
			ServletContext context=getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/assisment2.html");
			rd.forward(request,response);
			}

	}

}

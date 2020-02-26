

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class assignment2 extends HttpServlet
{
	Connection con=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String a=(String)request.getAttribute("username");
		HttpSession sess=request.getSession();
		int eno=Integer.parseInt(request.getParameter("eno"));
		String  ename=request.getParameter("ename");
		float esal=Float.parseFloat(request.getParameter("esal"));
		int  eage=Integer.parseInt(request.getParameter("eage"));
		sess.setAttribute("enoo", eno);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gaya3","root","root");
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		
		ps.setInt(1,eno);
		ps.setString(2,ename);
		ps.setFloat(3,esal);
		ps.setInt(4,eage);
		ps.executeUpdate();
		//ResultSet rs=ps.executeQuery();
	}
		catch(SQLException | ClassNotFoundException se) 
		{System.out.println(se);}
		
		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/assisment3.html");
		rd.forward(request,response);
}
}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class assignment5 extends HttpServlet
{
	ResultSet rs=null;Connection con=null;PreparedStatement ps=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gaya3","root","root");
		int number=Integer.parseInt(request.getParameter("eno"));
		
	  ps=con.prepareStatement("delete from employee where eno="+number);
		ps.executeUpdate();
		ps.close();
		
		ps=con.prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			out.println(rs.getInt("eno"));
			out.println(rs.getString("ename"));
			out.println(rs.getFloat("esal"));
			out.println(rs.getInt("eage"));
		}
		
	}
		catch(SQLException | ClassNotFoundException se) 
		{System.out.println(se);}
		
	}

}

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
import javax.servlet.http.HttpSession;

public class assignment4 extends HttpServlet
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			PrintWriter out=response.getWriter();
			HttpSession sess=request.getSession();
		    int aa=(int)sess.getAttribute("enoo");
		    
		    System.out.println(aa);
		    
		    Connection con=null;
			String  ename=request.getParameter("ename");
			float esal=Float.parseFloat(request.getParameter("esal"));
			int  eage=Integer.parseInt(request.getParameter("eage"));
			PreparedStatement ps=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gaya3","root","root");
			ps=con.prepareStatement("update employee set ename=?,esal=?,eage=? where eno=?");
			ps.setString(1,ename);
			ps.setFloat(2,esal);
			ps.setInt(3,eage);
			ps.setInt(4, aa);
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

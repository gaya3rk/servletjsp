

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gaya3","root","root");
	String name1=request.getParameter("username");
	String  password=request.getParameter("password");
	if
	



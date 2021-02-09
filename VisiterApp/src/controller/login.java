package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import visiterconnection.visiterconnection;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		PrintWriter out=response.getWriter();
		String email,pass;
		email=request.getParameter("email");
		pass=request.getParameter("pass");
		try
		{
			Connection con=visiterconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select count(*) from login where email = '" +email+ "' and pass = '"+pass+"'");
			ResultSet rs=pst.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count==1)
			
			{
				response.sendRedirect("admin.jsp");
			} 
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('something is wrong');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}

	}

}

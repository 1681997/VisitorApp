package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visiterconnection.visiterconnection;


/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		String  name,qualification,contact,email,address,reason;
		
		name=request.getParameter("name");
		qualification=request.getParameter("qualification");
		contact=request.getParameter("contact");
		email=request.getParameter("email");
		address=request.getParameter("address");
		reason=request.getParameter("reason");
		
		try
		{
			Connection con = visiterconnection.getConnection();
			PreparedStatement pst1 = con.prepareStatement("select count(*) from register where email='" +email+ "'");
			ResultSet rs=pst1.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			if (count == 0)
			{
				PreparedStatement pst = con.prepareStatement(
						"insert into register(name,qualification,contact,email,address,reason,date) values(?,?,?,?,?,?,?)");
				Date today=new Date();
			    SimpleDateFormat Date=new SimpleDateFormat("yyyy-MM-dd");
			   
			    String tdate=Date.format(today);
			    
				pst.setString(1, name);
				pst.setString(2, qualification);
				pst.setString(3, contact);
			    pst.setString(4, email);
			    pst.setString(5, address);
			    pst.setString(6, reason);
			    pst.setString(7, tdate);
			  
			    pst.executeUpdate();
			    
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Registration Sucesssful....!!!');");
			    out.println("location='register.jsp';");
			    out.println("</script>");
			    
			}
			else
			{
				 out.println("<script type=\"text/javascript\">");
				    out.println("alert('Email Already Exists...!!!');");
				    out.println("location='register.jsp';");
				    out.println("</script>");
				
				
			}
				
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}

}

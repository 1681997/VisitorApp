package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visiterconnection.visiterconnection;



/**
 * Servlet implementation class Company
 */
@WebServlet("/Company")
public class Company extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PrintWriter out = response.getWriter();
		String company_name, company_email, company_address;
		company_name = request.getParameter("company_name");
		company_email = request.getParameter("company_email");
		company_address = request.getParameter("company_address");
         
		try {
			Connection con = visiterconnection.getConnection();
			PreparedStatement pst1 = con
					.prepareStatement("select count(*) from company where company_email= '" + company_email + "'");
			ResultSet rs = pst1.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count == 0) {

				PreparedStatement pst = con.prepareStatement(
						"insert into company(company_name, company_email, company_address) values (?,?,?)");
				pst.setString(1, company_name);
				pst.setString(2, company_email);
				pst.setString(3, company_address);
				pst.executeUpdate();

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration Sucesssful....!!!');");
				out.println("location='admin.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email Already Exists...!!!');");
				out.println("location='Company.jsp';");
				out.println("</script>");
			}
	           
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

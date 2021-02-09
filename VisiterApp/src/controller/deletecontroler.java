package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visiterconnection.visiterconnection;


/**
 * Servlet implementation class deletecontroler
 */
@WebServlet("/deletecontroler")
public class deletecontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecontroler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String id=request.getParameter("id");
		try
		{
			Connection con=visiterconnection.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from register where id='"+id+"'");
			pst.executeUpdate();
			response.sendRedirect("view.jsp");
			
			
		}catch	(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}

package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_book
 */
@WebServlet("/add_book")
public class add_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String bname = request.getParameter("bname");
		String bedition = request.getParameter("bedition");
		String bprice = request.getParameter("bprice");
		String bauthor = request.getParameter("bauthor");
		

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it64","imsc7it64","sumo@123");
			String insertSQL = "INSERT INTO Book(bname,bedition,bprice,bauthor) VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insertSQL);

			pst.setString(1, bname);
			pst.setString(2,bedition);
			pst.setString(3, bprice);
			pst.setString(4, bauthor);
			pst.executeUpdate();

			out.println("BOOK ADDED");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}
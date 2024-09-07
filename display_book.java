package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display_book
 */
@WebServlet("/display_book")
public class display_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display_book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it64","imsc7it64","sumo@123");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Book");
			ResultSet rs = pst.executeQuery();

			while(rs.next())
			{
				String bname = rs.getString(2);
				String bedition = rs.getString(3);
				String bprice = rs.getString(4);
				String bauthor = rs.getString(5);

				String linkUrl = "Details?bname="+bname+"&bedition="+bedition+"&bprice="+bprice+"&bauthor="+bauthor;

				out.println("<html>");
				out.println("<body>");

				out.println("<a href'"+linkUrl+"'>"+bname+"</a>");
				
				out.println("</body>");
				out.println("</html>");	

				//out.println(bname);
				//out.println(bedition);
				//out.println(bprice);
				//out.println(bauthor);
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
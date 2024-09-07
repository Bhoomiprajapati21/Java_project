package book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
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

		String bname = request.getParameter("bname");
		String bedition = request.getParameter("bedition");
		String bprice = request.getParameter("bprice");
		String bauthor = request.getParameter("bauthor");

		out.println("<html>");
		out.println("<body>");

		out.println("<h1>Book name : "+bname+"</h1>");
		out.println("<h1>Book edition : "+bedition+"</h1>");
		out.println("<h1>Book price : "+bprice+"</h1>");
		out.println("<h1>Book author : "+bauthor+"</h1>");

		String linkurl = "index.html";
		String text = "Home";
		out.println("<a href'"+linkurl+"'>"+text+"</a>");

		out.println("</body>");
		out.println("</html>");	

		out.close();
	}

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TODO Auto-generated method stub
		doGet(request, response);
	}
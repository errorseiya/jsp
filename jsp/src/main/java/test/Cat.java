package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cat
 */

@WebServlet("/Cat")

public class Cat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
 
        out.println(output("Get"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
 
        out.println(output("Post"));
	}

	
	public StringBuffer output(String type){
        StringBuffer sb = new StringBuffer();
 
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Lime</title>");
        sb.append("</head>");
        sb.append("<body>");
 
        sb.append("<p>呼び出し方法：" + type + "送信</p>");
 
        sb.append("<a href='Cat'>リンク</a>");
 
        sb.append("<form action='Cat' method='get'>");
        sb.append("<input type='submit' value='GET送信' />");
        sb.append("</form>");
 
        sb.append("<form action='Cat' method='post'>");
        sb.append("<input type='submit' value='POST送信' />");
        sb.append("</form>");
 
        sb.append("</body>");
        sb.append("</html>");
 
        return (sb);
    }

}

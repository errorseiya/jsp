package day06;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample02
 */


//以下がURLを決めるアノテーション
	@WebServlet("/day06/Sample02")
public class Sample02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
//		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(output("Post"));
	}
	
	
/* StringBufferクラス  Stringクラスの違い
 * 
 * Stringクラスとの違いとして、
 * 変数に文字列を格納したあとでも「値を追加」「挿入」「変更」などの、文字列操作が可能。

つまり、
StringBufferクラスは、文字列の値が「不変である」と分かっているときに、使用するケースが多いと言えます
 */


	public StringBuffer output(String type) {
		StringBuffer sb = new StringBuffer();
		
		// appendメソッドを使用して、文字列を結合
		sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Sample02</title>");
        sb.append("</head>");
        sb.append("<body>");
 
        sb.append("<p>呼び出し方法：" + type + " 送信</p>");
 
        sb.append("<a href='Sample02'>リンク</a>");
 
        sb.append("<form action='Sample02' method='get'>");
        sb.append("<input type='submit' value='GET送信' />");
        sb.append("</form>");
 
        sb.append("<form action='Sample02' method='post'>");
        sb.append("<input type='submit' value='POST送信' />");
        sb.append("</form>");
 
        sb.append("</body>");
        sb.append("</html>");
        
        
        return (sb);
	}

}
	
/*
// appendメソッドを使用して、文字列を結合する
    sStrBuf1.append(sStrBuf2);
    System.out.println(sStrBuf1);-->「appleorange」

// insertメソッドを使用して、文字列” and ”を挿入する
    sStrBuf1.insert(5, " and ");
    System.out.println(sStrBuf1);-->「apple and orange」
    
   */

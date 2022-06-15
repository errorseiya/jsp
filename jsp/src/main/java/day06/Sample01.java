package day06;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Sample01
 */

/*
 * URLの決定
 * サーブレットの場合はURLを設定しなければならない
 * ＊今回、URLは、http://localhost:8080/jsp/　までは決まっている為それ以降のURLを設定
 * 
 * 以下がURLを決めるアノテーション
 */
@WebServlet("/day6/Sample01")

public class Sample01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*
 * Webブラウザからの要求を処理するのが「request」
 * Webサーバからの応答を処理するためのが「response」となる
 * そして↓
 */
	//今回は、requestで、リクエストのキャラクターエンコードをutf-8に
	//responseで出力するHTMLのエンコードをを同じくutf-8にしている
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
/*
 * HTMLを出力するためのオブジェクトをresponseのgetWriter()メソッドを使用
 * 
 * outオブジェクトの取得
	PrintWriter out = response.getWriter();
	
PrintWriterクラスは、print()メソッドやprintln()メソッド、
更にprintf()メソッドとformat()メソッドも実装しているクラスで、
コンソールに文字を出力する「System.out」System.out.println()のようにして
							様々なターゲットに文字列を出力できるためのクラス
 */
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>SampleServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HelloServlet</h1>");
        out.println("<h2>doGetとdoPost</h2>");
        out.println("<p><b>doGetメソッド</b>は、外部から、<b>GET送信が送られてきた時に実行されるメソッド</b>です。<br>"
        		+ "同様に、<b>POST送信が行われてきた時の処理を実行するメソッド</b>として、<b>doPost</b>があります。<br>"
        		+ "ここでは、doGetの身を使っています。<br>"
        		+ "このサンプルのように、単純にURLを指定し実行するタイプであれば、doGetでよいでしょう。</p>");
        out.println("</body>");
        out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




/*
 *  web.xml格納場所は、
 *  ＜プロジェクト名（コンテキスト）＞\ WebApp\ WEB-INF\ web.xml
 *  
 *  <servlet>タグ
 *  <servlet-mapping>タグで囲まれた部分
 *  
 *  
 *  <servlet-name>はそのまま他と区別する名前を記述しています。
 *  <servlet>要素の<servlet-class>は実際に実行するクラスファイルの完全修飾されたクラス名を記述。
 *  
 *  <servlet-mapping>要素の <url-pattern> は、
 *  アプリケーションコンテキストからの『/』以降を記述します。
 *  
 *  http//localhost:8080/jsp/day6/Sample01であれば、
 *  
 *  アプリケーションコンテキストはjspなのでその「/」以降の/day6/Sample01が記述されています。


現在は実際にはweb.xmlを操作することはありませんが、
Javaのバージョンによってはweb.xmlが必要になることが必要になるので、注意が必要。
 */

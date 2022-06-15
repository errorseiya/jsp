package day07;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalenderAccess
 */

@WebServlet("/day7/CalenderAccess")
public class CalenderAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalenderAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		prepData(request);
		
/*
 * getRequestDispatcherメソッド
 * ...引数にURLを指定し、そのURLに対するRequestDispatcherオブジェクトを生成
 * URLはコンテキストルートから/(スラッシュ）を含めて絶対パスで指定するか、
 * 呼び出すプログラムからの相対パスで指定。
 */
        RequestDispatcher dispatcher = request.getRequestDispatcher("Calender.jsp");
        
 /*
  * 属性の設定が終わったら、次は属性の値を持ったままでページ遷移を行う必要があります。
  * そのためには、フォワードと呼ばれる処理を行う必要があります。
  * 
  * 生成されたオブジェクトの、forwardメソッドを利用すれば、指定されたページに遷移できる。
  * 
  * フォワードには引数として、
  * request並びにresponseを必要とします。これにより、requestの属性が、遷移先のページで取得できる。
  */
        //  フォワードによるページ遷移
        dispatcher.forward(request, response);
     //↑をすることで、遷移先で「request.getAttribute(setで指定した第１引数)」で値を取得できる
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

//  送信用のデータの作成
    private void prepData(HttpServletRequest request){
        // 変数初期化
        int startday;
        int lastday;
        //  カレンダーの取得
        Calendar cal = Calendar.getInstance();
        
    //prepDataメソッドの中の「GET送信時のパラメータの有無」で区別
    //送信時にパラメータが設定されていると、requestのgetParamaterメソッドでデータを取得でき
        //  年が設定されていれば、その値を取得。そうでなければ、今年の年号を入れる。
        if(request.getParameter("year")==null){  //これで初期アクセスか判断
            request.setAttribute("year", cal.get(Calendar.YEAR));   //  現在の年を取得
 
        }else{
            request.setAttribute("year", request.getParameter("year")); //  与えられた年
        }
        if(request.getParameter("month")==null){
            request.setAttribute("month", cal.get(Calendar.MONTH)+1);   //  現在の月を取得 +1しているのは、1月が0だから
        }else{
            request.setAttribute("month", request.getParameter("month"));   //  与えられた月
        }
        
        //数値を文字列に変換するためのtoStringメソッド
        
//request.getAttribute( )で呼び出しただけでは、String型ではない(Object型？)ため、.toString()で変換
      //Integer.parseInt( )でString型をInt型に変換
        int year = Integer.parseInt(request.getAttribute("year").toString());
        int month = Integer.parseInt(request.getAttribute("month").toString());
        
        
 /*
  * Calendarクラスのsetメソッドは、カレンダーの時刻や日付などの要素を設定するときに使用
  * 
  * 指定されたフィールドにCalendarクラスの定数などをセットします。（YEAR、MONTH、DATE、HOUR、MINUTEなど）
  * 
  * 
  * // 日時を年月日時分秒で設定　　cl.set(YEAR, MONTH, DATE(日にち), HOUR, MINUTE, SECOND);
  */
        // 月初めの曜日(日-> 1)
    //「 month - 1」にしないとひと月分ずれる（与えられた数値はCalendarで取得したのではなく画面出力上に＋1されたものだから）
        cal.set(year, month - 1, 1); 
        
       //現在（今日）の曜日（Calendar.DAY_OF_WEEK）を取得（cal.get(Calendar.DAY_OF_WEEK);）
        //Calendar.DAY_OF_WEEKで取得できるリターン値は、日曜が1で始まる1～7 の数字
        //1日の曜日を、数値として取得
        startday = cal.get(Calendar.DAY_OF_WEEK);//startday = 開始日
  /*
   * Calendarクラスのaddメソッドは、
   * Calendarのオブジェクトが保持している日時に対して、指定した値を加算/減算などの演算をするときに使用
   */
        // 月末の日付
        cal.add(Calendar.MONTH, 1);	//もしかして、ここで「指定された月」の「次の月」を指定して
        cal.add(Calendar.DATE, -1);//「次の月」から１日引いて、結果的に「指定された月の月末の日にち」をセットして
        lastday = cal.get(Calendar.DATE);//取得してると。ふーむ
        
        //  カレンダーのデータを作成する
        int date = 1;
        int maxday = 5 * 7;
        
        
        StringBuilder sb = new StringBuilder();//可変前提のtextファイルをいれてくから宣言
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th style=\"color:red;\">日</th>");
        sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
        sb.append("<th style=\"color:blue;\">土</th>");
        sb.append("</tr>");
        sb.append("<tr>");
        for (int num = 1; num <= maxday; num++) {
//「num < startday」で、１日までの空白を、
//「 num > lastday + startday - 1」で、月末の日にち以降かつ、決められたカレンダーサイズ内上限まで空白を作成
            if(num < startday || num > lastday + startday - 1){
                sb.append("<td></td>");
            }else{
                sb.append("<td>"+date+"</td>");
                date++;
            }
            if(num % 7 == 0){ //土曜日を迎えたら、その行を閉じて、以下の状態なら改行または終了
                sb.append("</tr>");
                if(num > startday + lastday - 1){  //月末がピッタリ土曜日	つかカレンダー上限の３５なら終了		
                    break;
                }
                if(date < lastday){ //月末でないなら、続行
                    sb.append("<tr>");
                }else{
                    //  最後だったら、ループから抜ける
                    break;
                }
            }
        }
        sb.append("</table>");
        //  パラメータを設定
        request.setAttribute("calender", sb);
        return;
    }
}

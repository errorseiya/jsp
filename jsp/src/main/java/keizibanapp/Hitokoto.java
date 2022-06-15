//package keizibanapp;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Hitokoto
// */
//@WebServlet("/Hitokoto")
//public class Hitokoto extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Hitokoto() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//doGet(request, response);
//		
//		getData(request);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("KeizibanApp.jsp");
//		
//		dispatcher.forward(request, response);
//	}
//	
//	protected void getData(HttpServletRequest request) {
//		
//		if(request.getParameter("name") == null) {
//			request.setAttribute("name","名無し");
//		}else {
//			request.setAttribute("name",request.getParameter("name"));
//		}
//		
//		if(request.getParameter("comment") == null) {
//			request.setAttribute("error","コメントが入力されていません");
//		}else {
//			request.setAttribute("name",request.getParameter("comment"));
//		}
//		
//		
//		return;
//	}
//
//}

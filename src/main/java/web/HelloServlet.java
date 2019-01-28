package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public HelloServlet(){
		System.out.println("HelloServlet's constructor");
	}
	
	@Override
	/**
	 * Servlet容器收到请求之后，会先创建Servlet对象,接下来，容器会调用该对象的service方法。
	 * 注:
	 * 	 容器会解析请求数据包，并且将解析到的数据存放 到request对象里面，然后再创建一个response
	 * 对象。容器会将request和response作为参数传递给service方法。
　　　　　作为开发人员，只需要调用request对象提供的方法，就可以获得请求数据包里面的所有数据，
		类似的，也只需要调用response对象提供的方法，就可以将处理结果发送给浏览器。
	 */
	protected void service(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException,IOException {
		System.out.println("HelloServlet's service");
		/*
		 * 依据请求参数名("number")获得请求参数值
		 */
		String number =request.getParameter("number");
		Integer.parseInt(number);
		/*
		 * 当有多个请求参数名相同时，使用request的
		 * getParameterValues方法。注意，对于多选
		 * 框，如果没有选择任何选项，会获得null值。
		 */
		String[] city =request.getParameterValues("city");
		if(city!= null){
			for(String c : city){
				System.out.println("c:" + c);
			}
		}
		
		/*
		 * 设置响应头。
		 * 即设置content-type消息头，告诉浏览器，
		 * 服务器端返回的数据类型。
		 * 
		 * MIMA类型 
		 *      image/jpeg image/png
		 * 
		 */
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = 
				response.getWriter();
		/*
		 * 将处理结果写到response对象上。
		 * 容器在service方法结束之前，会从response
		 * 对象上取出处理结果，然后创建响应数据包，
		 * 并发送给浏览器。
		 */
		//servlet输出中文 out.println方法输出，默认使用“iso-8859-1”编码 所以就乱码
		
		out.println("<h1>你好 wisdombo</h1>");
		out.close();
		
		
	}
	
}
	
	
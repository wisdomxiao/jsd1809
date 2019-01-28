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
	 * Servlet�����յ�����֮�󣬻��ȴ���Servlet����,����������������øö����service������
	 * ע:
	 * 	 ����������������ݰ������ҽ������������ݴ�� ��request�������棬Ȼ���ٴ���һ��response
	 * ���������Ὣrequest��response��Ϊ�������ݸ�service������
������������Ϊ������Ա��ֻ��Ҫ����request�����ṩ�ķ������Ϳ��Ի���������ݰ�������������ݣ�
		���Ƶģ�Ҳֻ��Ҫ����response�����ṩ�ķ������Ϳ��Խ����������͸��������
	 */
	protected void service(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException,IOException {
		System.out.println("HelloServlet's service");
		/*
		 * �������������("number")����������ֵ
		 */
		String number =request.getParameter("number");
		Integer.parseInt(number);
		/*
		 * ���ж�������������ͬʱ��ʹ��request��
		 * getParameterValues������ע�⣬���ڶ�ѡ
		 * �����û��ѡ���κ�ѡ�����nullֵ��
		 */
		String[] city =request.getParameterValues("city");
		if(city!= null){
			for(String c : city){
				System.out.println("c:" + c);
			}
		}
		
		/*
		 * ������Ӧͷ��
		 * ������content-type��Ϣͷ�������������
		 * �������˷��ص��������͡�
		 * 
		 * MIMA���� 
		 *      image/jpeg image/png
		 * 
		 */
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = 
				response.getWriter();
		/*
		 * ��������д��response�����ϡ�
		 * ������service��������֮ǰ�����response
		 * ������ȡ����������Ȼ�󴴽���Ӧ���ݰ���
		 * �����͸��������
		 */
		//servlet������� out.println���������Ĭ��ʹ�á�iso-8859-1������ ���Ծ�����
		
		out.println("<h1>��� wisdombo</h1>");
		out.close();
		
		
	}
	
}
	
	
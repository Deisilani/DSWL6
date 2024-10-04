package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Exe03
 */
@WebServlet("/Exe03")
public class Exe03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe03() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	out.println("<html><body>");
    	out.println("<h1>Bem-vindo</h1>"
    			+ "    <form method=\"POST\">\r\n"
    			+ "        <label for=\"username\">Nome de Usuario:</label><br>\r\n"
    			+ "        <input type=\"text\" id=\"username\" name=\"username\" required><br><br>\r\n"
    			+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
    			+ "    </form>");
    	out.println("</body></html>");
    	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Bem-Vindo ").append(request.getParameter("username"));
	}

}

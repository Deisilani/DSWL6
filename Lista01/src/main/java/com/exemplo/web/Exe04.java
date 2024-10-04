package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Exe04
 */
@WebServlet("/Exe04")
public class Exe04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int contadorAcessos = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe04() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contadorAcessos++;
		
		response.getWriter().append("Numero de acessos: ").append(String.valueOf(contadorAcessos));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Servlet implementation class Exe07
 */
@WebServlet("/Exe07")
public class Exe07 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HashMap<String, Integer> contadorAcessos = new HashMap<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe07() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        if (nome != null && !nome.trim().isEmpty()) {
            contadorAcessos.put(nome, contadorAcessos.getOrDefault(nome, 0) + 1);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Contador de Acessos por Usuário:</h1>");
        out.println("<ul>");
        for (String user : contadorAcessos.keySet()) {
            out.println("<li>" + user + ": " + contadorAcessos.get(user) + " acessos</li>");
        }
        out.println("</ul>");
        out.println("<form action='/Aula02/Exe07' method='get'>");
        out.println("Digite seu nome: <input type='text' name='nome'>");
        out.println("<input type='submit' value='Contar Acesso'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

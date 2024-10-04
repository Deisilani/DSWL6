package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Exe05
 */
@WebServlet("/addNome")
public class Exe05 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private List<String> nomes = new ArrayList<>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe05() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        if (nome != null && !nome.trim().isEmpty()) {
            nomes.add(nome);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Nomes armazenados:</h1>");
        out.println("<ul>");
        for (String n : nomes) {
            out.println("<li>" + n + "</li>");
        }
        out.println("</ul>");
        out.println("<form action='/Aula02/addNome' method='get'>");
        out.println("Digite um nome: <input type='text' name='nome'>");
        out.println("<input type='submit' value='Adicionar Nome'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

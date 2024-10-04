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
 * Servlet implementation class exe09
 */
@WebServlet("/exe09")
public class exe09 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public exe09() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> nomes = (List<String>) getServletContext().getAttribute("nomes");
        if (nomes == null) {
            nomes = new ArrayList<>();
            getServletContext().setAttribute("nomes", nomes);
        }

        String nome = request.getParameter("nome");
    
        if (nome != null && !nome.trim().isEmpty()) {
           
            if (nomes.contains(nome)) {
                nomes.remove(nome);
            } else {
                nomes.add(nome);
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Nomes Cadastrados:</h1>");
        out.println("<ul>");
        for (String n : nomes) {
            out.println("<li>" + n + "</li>");
        }
        out.println("</ul>");

        out.println("<h2>Adicionar ou Remover Nome:</h2>");
        out.println("<form action='/Aula02/exe09' method='get'>");
        out.println("Nome: <input type='text' name='nome' required>");
        out.println("<input type='submit' value='Adicionar ou Remover Nome'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}

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
 * Servlet implementation class Exe06
 */
@WebServlet("/Exe06")
public class Exe06 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<String> comentarios = new ArrayList<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe06() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Adicionar Comentário:</h1>");
        out.println("<form action='/Aula02/Exe06' method='post'>");
        out.println("Digite um comentário: <input type='text' name='comentario'>");
        out.println("<input type='submit' value='Adicionar Comentário'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comentario = request.getParameter("comentario");
        
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentarios.add(comentario);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Comentários armazenados:</h1>");
        out.println("<ul>");
        for (String c : comentarios) {
            out.println("<li>" + c + "</li>");
        }
        out.println("</ul>");
        out.println("<form action='/Aula02/Exe06' method='post'>");
        out.println("Digite um comentário: <input type='text' name='comentario'>");
        out.println("<input type='submit' value='Adicionar Comentário'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

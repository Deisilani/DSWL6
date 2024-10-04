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
 * Servlet implementation class Exe10
 */
@WebServlet("/Exe10")
public class Exe10 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe10() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> tarefas = (List<String>) getServletContext().getAttribute("tarefas");
        if (tarefas == null) {
            tarefas = new ArrayList<>();
            getServletContext().setAttribute("tarefas", tarefas);
        }

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Lista de Tarefas</h1>");
        out.println("<ul>");
        for (String tarefa : tarefas) {
            out.println("<li>" + tarefa + "</li>");
        }
        out.println("</ul>");

        out.println("<h2>Adicionar Nova Tarefa:</h2>");
        out.println("<form action='/Aula02/Exe10' method='post'>");
        out.println("Tarefa: <input type='text' name='tarefa' required>");
        out.println("<input type='submit' value='Adicionar Tarefa'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 
        List<String> tarefas = (List<String>) getServletContext().getAttribute("tarefas");
        if (tarefas == null) {
            tarefas = new ArrayList<>();
            getServletContext().setAttribute("tarefas", tarefas);
        }
 
        String novaTarefa = request.getParameter("tarefa");
        if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
            tarefas.add(novaTarefa); 
        }

        doGet(request, response);
    }
}

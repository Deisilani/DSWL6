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
 * Servlet implementation class Exe08
 */
@WebServlet("/Exe08")
public class Exe08 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Produto> produtos = new ArrayList<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe08() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Produtos Cadastrados:</h1>");
        out.println("<ul>");
        for (Produto produto : produtos) {
            out.println("<li>" + produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco()) + "</li>");
        }
        out.println("</ul>");

        out.println("<h2>Cadastrar Novo Produto:</h2>");
        out.println("<form action='/Aula02/Exe08' method='post'>");
        out.println("Nome: <input type='text' name='nome' required><br>");
        out.println("Preço: <input type='number' step='0.01' name='preco' required><br>");
        out.println("<input type='submit' value='Cadastrar Produto'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));

        produtos.add(new Produto(nome, preco));

        doGet(request, response);
    }

    private class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }
    }
}

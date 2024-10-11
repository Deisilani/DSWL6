package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Lista02")
public class Lista02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Lista02() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireciona para a página de login se a requisição for GET
        response.sendRedirect("login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");

        if (validarLogin(nomeUsuario, senha)) {
            response.sendRedirect("welcome.html");
        } else {
            response.sendRedirect("login.html?error=1");
        }
    }

    private boolean validarLogin(String nomeUsuario, String senha) {
        return "deisi".equals(nomeUsuario) && "1234".equals(senha);
    }
}

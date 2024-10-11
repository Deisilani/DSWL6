package com.exemplo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Exe01")
public class Exe01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Exe01() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Verifica qual ação executar (redirecionamento, despacho, sessão, cookies)
        if ("login".equals(action)) {
            login(request, response);  // Chama função de login e redirecionamento
        } else if ("dispatch".equals(action)) {
            dispatch(request, response);  // Chama função de despacho
        } else if ("session".equals(action)) {
            manageSession(request, response);  // Chama função de gerenciamento de sessão
        } else if ("cookie".equals(action)) {
            manageCookie(request, response);  // Chama função de gerenciamento de cookies
        }
    }

    // Função para redirecionamento (login simples)
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simulação de login
        if ("admin".equals(username) && "1234".equals(password)) {
            response.sendRedirect("welcome.jsp");  // Redireciona para página de boas-vindas
        } else {
            response.sendRedirect("error.jsp");  // Redireciona para página de erro
        }
    }

    // Função para despacho de requisição (Dispatch)
    private void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valor = request.getParameter("valor");
        request.setAttribute("valor", valor);  // Passa o valor para o próximo servlet ou JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);  // Despacha a requisição para a JSP
    }

    // Função para gerenciar sessões
    private void manageSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String nome = request.getParameter("nome");

        if (nome != null) {
            session.setAttribute("nomeUsuario", nome);  // Armazena o nome do usuário na sessão
        } else {
            session.invalidate();  // Invalida a sessão (logout)
        }
        response.sendRedirect("dashboard.jsp");  // Redireciona para o dashboard
    }

    // Função para gerenciar cookies
    private void manageCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String action = request.getParameter("cookieAction");

        if ("set".equals(action)) {
            Cookie cookie = new Cookie("nomeUsuario", nome);
            cookie.setMaxAge(60 * 60 * 24);  // Define tempo de expiração (1 dia)
            response.addCookie(cookie);  // Adiciona o cookie
            response.getWriter().println("Cookie definido com sucesso.");
        } else if ("remove".equals(action)) {
            Cookie cookie = new Cookie("nomeUsuario", "");
            cookie.setMaxAge(0);  // Remove o cookie
            response.addCookie(cookie);  // Aplica a remoção do cookie
            response.getWriter().println("Cookie removido com sucesso.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireciona para o método POST, caso o GET seja chamado
        doPost(request, response);
    }
}

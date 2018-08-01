/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servlet;

import atos.magiemagie.service.JoueurService;
import atos.magiemagie.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author theklaude
 */
@WebServlet(name = "RejoindrePartieServlet", urlPatterns = {"/pseudo-avatar"})
public class PseudoAvatarServlet extends AutowireServlet {

    private JoueurService jService = new JoueurService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("partieId", Long.parseLong(req.getParameter("idPartie")));
        req.getRequestDispatcher("pseudo-avatar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jService.rejoindrePartie(req.getParameter("pseudo"), req.getParameter("avatar"), (long) req.getSession().getAttribute("partieId"));
        resp.sendRedirect("demarrer-partie");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.servlet;

import atos.magiemagie.entity.Partie;
import atos.magiemagie.service.PartieService;
import atos.magiemagie.spring.AutowireServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author theklaude
 */
@WebServlet(name = "ListerPartieServlet", urlPatterns = {"/lister-partie"})
public class ListerPartieServlet extends AutowireServlet {

    //private  PartieService service= new PartieService();
    @Autowired
    private PartieService service;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Partie> parties = service.listerPartieNonDemarees();
        req.setAttribute("listeParties", parties);
 
        req.getRequestDispatcher("lister-partie.jsp").forward(req, resp);
        
    }
    
}

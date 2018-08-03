/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author theklaude
 */
@Controller
public class PartieController {
    @RequestMapping(value={"/home", "/"},method=RequestMethod.GET)
    public String test(){
        return "home.jsp";
    }
    
}

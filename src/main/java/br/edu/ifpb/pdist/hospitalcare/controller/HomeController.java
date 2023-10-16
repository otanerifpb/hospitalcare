package br.edu.ifpb.pdist.hospitalcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // Rota para mostar a Página principal index
    @RequestMapping("/home")
    public String showHomePage() {
        return "index";
    } 

    // Ativa o menu Home na barra de navegação
    @ModelAttribute("menu")
    public String activeMenu(){
        return "home";
    }
    
}

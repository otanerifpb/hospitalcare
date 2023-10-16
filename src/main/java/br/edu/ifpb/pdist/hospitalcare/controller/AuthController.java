package br.edu.ifpb.pdist.hospitalcare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    // Rota para o acessar com uso do GET
    // Cria um novo objeto conhecido como "cookie", para identificar o Usuário
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getForm(ModelAndView mav) {  
        mav.setViewName("/auth/formLogin");
       // mav.addObject("estudante", new Estudante());
        return mav;
    }

    // Rota para o sair da Sessão
    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView mav, HttpSession session) {
        session.invalidate();
        mav.setViewName("redirect:/auth");
        return mav;
    }
}

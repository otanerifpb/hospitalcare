package br.edu.ifpb.pdist.hospitalcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pdist.hospitalcare.model.Medico;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    // Rota para acessar o formunário
    //@PreAuthorize("hasRole('ADMIN')") /*Só o perfil Admin tem autorização para acessar */
    @RequestMapping("/formMedico")
    public ModelAndView getFormMedico(Medico medico, ModelAndView mav) {
        mav.addObject("medico", medico);
        mav.setViewName("medicos/formMedico");
        return mav;
    }

    // Ativa o menu Estudante na barra de navegação
    @ModelAttribute("menu")
    public String activeMenu(){
        return "medicos";
    }
    
}

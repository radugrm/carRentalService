package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.FindClientDto;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import static com.raflo.rentalService.controllers.dto.FindClientDto.FIND_CLIENT_FORM;

@Controller
@RequestMapping("/rent2")
public class RentalController2 {

    @Autowired
    ClientService clientService;

//    Client client;

    @GetMapping
    public String rent2(Model model){
        model.addAttribute(FIND_CLIENT_FORM,new FindClientDto());
        return "rental2/rent2_page";
    }

    @PostMapping(value = "/cnp")
    public ModelAndView clientCnp(RedirectAttributes redirectAttrs, @ModelAttribute (FIND_CLIENT_FORM) FindClientDto form){
        if(clientService.findByCnp(form.getCnp()).isPresent()){
            redirectAttrs.addFlashAttribute("client",clientService.findByCnp(form.getCnp()).get());
        }
        else{
            Client client1 = new Client();
            client1.setCnp(form.getCnp());
            redirectAttrs.addFlashAttribute("client",client1);
        }
        return new ModelAndView("redirect:/rent2");
    }
}

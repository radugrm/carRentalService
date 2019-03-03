package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.NewClientFormDto;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static com.raflo.rentalService.controllers.dto.NewClientFormDto.NEW_CLIENT_FORM;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String showClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("companyName", "RAFLO");
        model.addAttribute("clientList", clients);
        model.addAttribute(NEW_CLIENT_FORM, new NewClientFormDto());
        return "clients/clients_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createClient(@ModelAttribute(NEW_CLIENT_FORM) NewClientFormDto form) {
        clientService.createClient(form.getFirstName(), form.getLastName(), form.getCnp(), form.getPhoneNumber());
        return "redirect:/clients_page";
    }
}

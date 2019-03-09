package com.raflo.rentalService.controllers;

import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.services.ClientService;
import com.raflo.rentalService.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/rent")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String rent(Model model, @RequestParam(required = false) String cnp) {
        processCNPParameter(model, cnp);

        return "rent/rent_page";
    }

    private void processCNPParameter(Model model, String cnp) {
        Optional client;
        Optional<String> cnpOpt = Optional.ofNullable(cnp);
        if (cnpOpt.isPresent()) {
            client = clientService.findByCnp(cnp);

            if (!client.isPresent()) {
                model.addAttribute("clientByCnp", clientWithCNP(cnp));
            } else {

                model.addAttribute("clientByCnp", client.get());
            }
        } else {
            model.addAttribute("clientByCnp", new Client());
        }
    }


    private Client clientWithCNP(String cnp) {
        Client client = new Client();
        client.setCnp(cnp);
        return client;
    }
}

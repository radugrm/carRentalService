package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.DeleteClientFormDto;
import com.raflo.rentalService.controllers.dto.DeleteRentalFormDto;
import com.raflo.rentalService.model.Rental;
import com.raflo.rentalService.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.raflo.rentalService.controllers.dto.DeleteRentalFormDto.DELETE_RENTAL_FORM;

@Controller
@RequestMapping("/rentlist")
public class RentalList {

    @Autowired
    RentalService rentalService;

    @GetMapping
    public String rentalList(Model model){
        List<Rental> rentals = rentalService.getAllRental();

        model.addAttribute("companyName","RAFLO");
        model.addAttribute("rentalList",rentals);
        model.addAttribute(DELETE_RENTAL_FORM,new DeleteRentalFormDto());
        return "rental_list/rental_table";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteClient (@ModelAttribute(DELETE_RENTAL_FORM) DeleteRentalFormDto form){
        rentalService.deleteRentalById(form.getRentalId());
        return "redirect:/rentlist";
    }

}

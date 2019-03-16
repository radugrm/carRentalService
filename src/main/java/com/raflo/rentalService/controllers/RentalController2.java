package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.DateFormDto;
import com.raflo.rentalService.controllers.dto.FindClientDto;
import com.raflo.rentalService.controllers.dto.NewRentalFormDto;
import com.raflo.rentalService.model.*;
import com.raflo.rentalService.services.CarService;
import com.raflo.rentalService.services.ClientService;
import com.raflo.rentalService.services.ExtraOptionService;
import com.raflo.rentalService.services.RentalService;
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


import java.time.LocalDate;
import java.util.*;

import static com.raflo.rentalService.controllers.dto.DateFormDto.DATE_FORM_DTO;
import static com.raflo.rentalService.controllers.dto.FindClientDto.FIND_CLIENT_FORM;
import static com.raflo.rentalService.controllers.dto.NewRentalFormDto.NEW_RENTAL_FORM;

@Controller
@RequestMapping("/rent2")
public class RentalController2 {

    @Autowired
    ClientService clientService;

    @Autowired
    RentalService rentalService;

    @Autowired
    CarService carService;

    @Autowired
    ExtraOptionService extraOptionService;

//    Client client;

    @GetMapping
    public String rent2(Model model,
                        @ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form) {
        if (form == null) {
            model.addAttribute(NEW_RENTAL_FORM, new NewRentalFormDto());
        } else {
            model.addAttribute(NEW_RENTAL_FORM, form);
        }
        return "rental2/rent2_page";
    }

    @PostMapping(value = "/refresh")
    public ModelAndView clientCnp(RedirectAttributes redirectAttrs, @ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form) {
        if (clientService.findByCnp(form.getClient().getCnp()).isPresent()) {
            form.setClient(clientService.findByCnp(form.getClient().getCnp()).get());

        }
        CarCategoryEnum carCategoryEnum = form.getCarCategory();
        if (carService.getCarsByCategory(carCategoryEnum).isPresent()) {
            form.setCarsByCategory(carService.getCarsByCategory(carCategoryEnum).get());

        }
        redirectAttrs.addFlashAttribute(NEW_RENTAL_FORM, form);
        return new ModelAndView("redirect:/rent2");
    }

    @PostMapping(value = "/new")
    public String createRental(@ModelAttribute("client") Client client, @ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form) {
        Optional<Client> byCnp = clientService.findByCnp(client.getCnp());
        Car car = carService.getFirstAvailableCarByMakeAndModel(true,form.getCarMake(), form.getCarModel());
        Set<ExtraOption> extraOptions = new HashSet<>();
        if(form.getNavigation()){
            extraOptions.add(extraOptionService.findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.NAVIGATION));
        }
        if(form.getInfantSeat()){
            extraOptions.add(extraOptionService.findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.INFANT_SEAT));
        }
        if(form.getToddlerSeat()){
            extraOptions.add(extraOptionService.findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.TODDLER_SEAT));
        }
        if (byCnp.isPresent()) {
            rentalService.createRental(byCnp.get(),car
                    , form.getStartDate(), form.getEndDate(),
                    form.getInsurance(), form.getAdditionalDrivers(), extraOptions);
        }

        return "redirect:/rent2";
    }



}

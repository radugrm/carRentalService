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
        if (carService.getAvailableCarsByCategory(carCategoryEnum).isPresent()) {
            List<Car> cars = carService.getAvailableCarsByCategory(carCategoryEnum).get();
            form.setCarsByCategory(cars.toArray(new Car[cars.size()]));
        }

        redirectAttrs.addFlashAttribute(NEW_RENTAL_FORM, form);
        return new ModelAndView("redirect:/rent2");
    }

    @PostMapping(value = "/new")
    public String createRental(@ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form) {
        Set<ExtraOption> extraOptions = new HashSet<>();
        Optional<Client> client = clientService.findByCnp(form.getClient().getCnp());
        Optional<Car> car = carService.getCarById(form.getCar().getId());
        ExtraOption navigation = extraOptionService
                .findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.NAVIGATION);
        ExtraOption infantSeat =extraOptionService
                .findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.INFANT_SEAT);
        ExtraOption toddlerSeat =extraOptionService
                .findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum.TODDLER_SEAT);
        if (form.isNavigation()) {
            extraOptions.add(navigation);
            navigation.setAvailability(false);
        }
        if (form.isInfantSeat()) {
            extraOptions.add(infantSeat);
            infantSeat.setAvailability(false);
        }
        if (form.isToddlerSeat()) {
            extraOptions.add(toddlerSeat);
            toddlerSeat.setAvailability(false);
        }
        if (client.isPresent() && car.isPresent()) {
            rentalService.createRental(client.get(),
                    car.get(), form.getStartDate(), form.getEndDate(),
                    form.isInsurance(), form.getAdditionalDrivers(), extraOptions);
            carService.changeCarAvailability(car.get().getId(),false);
        }

        return "redirect:/rent2";
    }


}

package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.NewRentalFormDto;
import com.raflo.rentalService.model.*;
import com.raflo.rentalService.services.CarService;
import com.raflo.rentalService.services.ClientService;
import com.raflo.rentalService.services.ExtraOptionService;
import com.raflo.rentalService.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static com.raflo.rentalService.controllers.dto.NewRentalFormDto.NEW_RENTAL_FORM;


@Controller
@RequestMapping("/rent")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    ClientService clientService;

    @Autowired
    ExtraOptionService extraOptionService;

    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String rent(Model model, @RequestParam(required = false) String cnp, @RequestParam(name = "carCategory", required = false) String category) {
        processCNPParameter(model, cnp);
        model.addAttribute("carCategoryOptions", CarCategoryEnum.values());
        model.addAttribute(NEW_RENTAL_FORM, new NewRentalFormDto(carsByCategory(category)));
        return "rent/rent_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRent(Model model, @ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form,
                           @ModelAttribute("clientByCnp") Client client) {
        rentalService.createRental(client,
                (carService.getFirstAvailableCarByMakeAndModel(true, form.getCarMake(),
                        form.getCarModel())), form.getStartDate(), form.getEndDate(),
                form.getInsurance(), form.getAdditionalDrivers(),
                getValidExtraOptionList(form));
        return "/";
    }

    private List<ExtraOption> getValidExtraOptionList(@ModelAttribute(NEW_RENTAL_FORM) NewRentalFormDto form) {
        List<ExtraOption> extraOptionList = new ArrayList<>();
        for (ExtraOptionCategoryEnum e : form.getExtraOptions()) {
            extraOptionList.add(extraOptionService.findFirstAvailableExtraOptionByCategory(e, true));
        }
        return extraOptionList;
    }

    private List<Car> carsByCategory(String category) {
        List<Car> carsByCategory = new ArrayList<>();
        if (category == null || category.isEmpty()) {
            carsByCategory.add(new Car());
        } else {
            carsByCategory = carService.getCarsByCategory(CarCategoryEnum.valueOf(category));
        }
        return carsByCategory;
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

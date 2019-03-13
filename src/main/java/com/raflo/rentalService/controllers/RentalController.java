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
    public String rent(Model model, @RequestParam(name = "client", required = false) String cnp,
                       @RequestParam(name = "carCategory", required = false) String category) {
        NewRentalFormDto form = new NewRentalFormDto();
        processCNPParameter(form, cnp);
        processCarsByCategory(form, category);
        model.addAttribute(NEW_RENTAL_FORM, form);

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

    private void processCarsByCategory(NewRentalFormDto form, String category) {
        Optional<List<Car>> carsByCategory;
        Optional<String> categoryOpt = Optional.ofNullable(category);
        if (categoryOpt.isPresent()) {
            carsByCategory = carService.getCarsByCategory(CarCategoryEnum.valueOf(category));
            if (!carsByCategory.isPresent()) {
                form.setCarsByCategory(new ArrayList<>());
            }else {
                form.setCarsByCategory(carsByCategory.get());
            }
        } else {
            form.setCarsByCategory(new ArrayList<>());
        }
    }

    private void processCNPParameter(NewRentalFormDto form, String cnp) {
        Optional<Client> client;
        Optional<String> cnpOpt = Optional.ofNullable(cnp);
        if (cnpOpt.isPresent()) {
            client = clientService.findByCnp(cnp);

            if (!client.isPresent()) {
                form.setClient(clientWithCNP(cnp));
            } else {

                form.setClient(client.get());
            }
        } else {
            form.setClient(new Client());
        }
    }


    private Client clientWithCNP(String cnp) {
        Client client = new Client();
        client.setCnp(cnp);
        return client;
    }
}

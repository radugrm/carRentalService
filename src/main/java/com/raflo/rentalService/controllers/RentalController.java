package com.raflo.rentalService.controllers;

import com.raflo.rentalService.controllers.dto.CarsBySomething;
import com.raflo.rentalService.controllers.dto.NewCarFormDto;
import com.raflo.rentalService.controllers.dto.RentalFormDto;
import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.model.Client;
import com.raflo.rentalService.services.CarService;
import com.raflo.rentalService.services.ClientService;
import com.raflo.rentalService.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.raflo.rentalService.controllers.dto.NewCarFormDto.NEW_CAR_FORM;
import static com.raflo.rentalService.controllers.dto.RentalFormDto.RENTAL_FORM;

@Controller
@RequestMapping("/rent")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    ClientService clientService;

    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String rent(Model model, @RequestParam(required = false) String cnp, @RequestParam(name = "carCategory", required = false ) String category) {
        processCNPParameter(model, cnp);
        model.addAttribute("carCategoryOptions", CarCategoryEnum.values());
        model.addAttribute(RENTAL_FORM, new RentalFormDto(carsByCategory(category)));
        return "rent/rent_page";
    }

//    @RequestMapping(method = RequestMethod.GET , value = "/getByCategory")
//    public String getByCateg(Model model, @RequestParam("carCategory") String category) {
//
////        processCNPParameter(model, cnp);
////        model.addAttribute("carCategoryOptions", CarCategoryEnum.values());
////        model.addAttribute(RENTAL_FORM, new RentalFormDto());
////        processCarListByCateg(model,categ);
//        return "rent/rent_page";
//    }

    private List<Car> carsByCategory (String category) {
        List<Car> carsByCategory = new ArrayList<>();
        if(category==null || category.isEmpty()){
            carsByCategory.add(new Car());
        }
        else {
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

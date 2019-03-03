package com.raflo.rentalService.controllers;


import com.raflo.rentalService.controllers.dto.DeleteClientFormDto;
import com.raflo.rentalService.controllers.dto.NewCarFormDto;
import com.raflo.rentalService.controllers.dto.NewClientFormDto;
import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.raflo.rentalService.controllers.dto.DeleteClientFormDto.DELETE_CLIENT_FORM;
import static com.raflo.rentalService.controllers.dto.NewCarFormDto.NEW_CAR_FORM;
import static com.raflo.rentalService.controllers.dto.NewClientFormDto.NEW_CLIENT_FORM;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCars(Model model) {
        List<Car> cars = carService.getAllCars();

        model.addAttribute("companyName", "RAFLO");
        model.addAttribute("carList", cars);
        model.addAttribute("carCategoryOptions", CarCategoryEnum.values());
        model.addAttribute(NEW_CAR_FORM, new NewCarFormDto());
//        model.addAttribute(DELETE_CLIENT_FORM, new DeleteClientFormDto());
        return "cars/cars_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createCar(@ModelAttribute(NEW_CAR_FORM) NewCarFormDto form) {
        carService.createCar(form.getMake(),form.getModel(),form.getCarCategory(),form.getNumberPlate());
        return "redirect:/cars";
    }
}

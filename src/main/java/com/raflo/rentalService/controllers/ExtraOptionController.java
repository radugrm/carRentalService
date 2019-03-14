package com.raflo.rentalService.controllers;


import com.raflo.rentalService.controllers.dto.DeleteCarFormDto;
import com.raflo.rentalService.controllers.dto.DeleteExtraOptionFormDto;
import com.raflo.rentalService.controllers.dto.NewCarFormDto;
import com.raflo.rentalService.controllers.dto.NewExtraOptionFormDto;
import com.raflo.rentalService.model.Car;
import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.ExtraOptionCategoryEnum;
import com.raflo.rentalService.services.ExtraOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.raflo.rentalService.controllers.dto.DeleteCarFormDto.DELETE_CAR_FORM;
import static com.raflo.rentalService.controllers.dto.DeleteExtraOptionFormDto.DELETE_EXTRA_OPTION_FORM;
import static com.raflo.rentalService.controllers.dto.NewCarFormDto.NEW_CAR_FORM;
import static com.raflo.rentalService.controllers.dto.NewExtraOptionFormDto.NEW_EXTRA_OPTION_FORM;


@Controller
@RequestMapping("/extras")
public class ExtraOptionController {
    @Autowired
    private ExtraOptionService extraOptionService;

    @RequestMapping(method = RequestMethod.GET)
    public String showExtraOptions(Model model) {
        List<ExtraOption> extraOptions = extraOptionService.getAllExtraOption();

        model.addAttribute("companyName", "RAFLO");
        model.addAttribute("extraOptionList", extraOptions);
        model.addAttribute("extraOptionsCategory", ExtraOptionCategoryEnum.values());
        model.addAttribute(NEW_EXTRA_OPTION_FORM, new NewExtraOptionFormDto());
        model.addAttribute(DELETE_EXTRA_OPTION_FORM, new DeleteExtraOptionFormDto());
        return "extras/extras_page";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createExtraOption(@ModelAttribute(NEW_EXTRA_OPTION_FORM) NewExtraOptionFormDto form) {
        extraOptionService.createExtraOption(form.getExtraOptionCategoryEnum());
        return "redirect:/extras";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteExtraOption (@ModelAttribute(DELETE_EXTRA_OPTION_FORM) DeleteExtraOptionFormDto form){
        extraOptionService.deleteExtraOptionById(form.getId());
        return "redirect:/extras";
    }
}

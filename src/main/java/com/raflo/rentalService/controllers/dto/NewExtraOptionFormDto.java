package com.raflo.rentalService.controllers.dto;

import com.raflo.rentalService.model.CarCategoryEnum;
import com.raflo.rentalService.model.ExtraOptionCategoryEnum;

public class NewExtraOptionFormDto {
    public static final String NEW_EXTRA_OPTION_FORM = "newExtraOptionForm";


    private ExtraOptionCategoryEnum extraOptionCategoryEnum;

    public ExtraOptionCategoryEnum getExtraOptionCategoryEnum() {
        return extraOptionCategoryEnum;
    }

    public void setExtraOptionCategoryEnum(ExtraOptionCategoryEnum extraOptionCategoryEnum) {
        this.extraOptionCategoryEnum = extraOptionCategoryEnum;
    }
}

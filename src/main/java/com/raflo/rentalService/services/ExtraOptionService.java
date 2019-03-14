package com.raflo.rentalService.services;

import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.ExtraOptionCategoryEnum;

import java.util.List;

public interface ExtraOptionService {

    List<ExtraOption> getAllExtraOption();

    ExtraOption createExtraOption(ExtraOptionCategoryEnum extraOptionCategoryEnum);

    ExtraOption findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum extraOptionCategoryEnum, boolean availability);

    void changeCarAvailability (long id, boolean availability);

}

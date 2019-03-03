package com.raflo.rentalService.services;

import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.ExtraOptionCategory;

import java.util.List;

public interface ExtraOptionService {

    List<ExtraOption> getAllExtraOption();

    ExtraOption createExtraOption(ExtraOptionCategory extraOptionCategory);

    void deleteExtraOptionById(Long id);
}

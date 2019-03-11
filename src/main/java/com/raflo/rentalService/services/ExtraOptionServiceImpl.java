package com.raflo.rentalService.services;

import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.ExtraOptionCategoryEnum;
import com.raflo.rentalService.repositories.ExtraOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraOptionServiceImpl implements  ExtraOptionService{

    @Autowired
    private ExtraOptionRepository extraOptionRepository;

    @Override
    public List<ExtraOption> getAllExtraOption() {
        return null;
    }

    @Override
    public ExtraOption createExtraOption(ExtraOptionCategoryEnum extraOptionCategoryEnum) {
        ExtraOption extraOption = new ExtraOption();
        extraOption.setExtraOptionCategoryEnum(extraOptionCategoryEnum);

        return extraOptionRepository.save(extraOption);
    }

    @Override
    public void deleteExtraOptionById(Long id) {
        extraOptionRepository.deleteById(id);
    }

    @Override
    public ExtraOption findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum extraOptionCategoryEnum, boolean availability) {
        return extraOptionRepository.findFirstByExtraOptionCategoryEnumAndAvailability(extraOptionCategoryEnum,availability);
    }
}

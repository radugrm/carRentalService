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
    public void changeExtraOptionAvailability(long id, boolean availability) {
        if(extraOptionRepository.findById(id).isPresent()) {
            ExtraOption extraOption = extraOptionRepository.findById(id).get();
            extraOption.setAvailability(availability);
            extraOptionRepository.save(extraOption);
        }
    }

    @Override
    public void deleteExtraOptionById(long id) {
        extraOptionRepository.deleteById(id);
    }

    @Override
    public List<ExtraOption> getAllExtraOption() {
        return extraOptionRepository.findAll();
    }

    @Override
    public ExtraOption createExtraOption(ExtraOptionCategoryEnum extraOptionCategoryEnum) {
        ExtraOption extraOption = new ExtraOption();
        extraOption.setExtraOptionCategoryEnum(extraOptionCategoryEnum);
        extraOption.setAvailability(true);

        return extraOptionRepository.save(extraOption);
    }


    @Override
    public ExtraOption findFirstAvailableExtraOptionByCategory(ExtraOptionCategoryEnum extraOptionCategoryEnum) {
        return extraOptionRepository.findFirstByExtraOptionCategoryEnumAndAvailability(extraOptionCategoryEnum,true);
    }
}

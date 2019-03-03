package com.raflo.rentalService.repositories;

import com.raflo.rentalService.model.ExtraOption;
import com.raflo.rentalService.model.ExtraOptionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraOptionRepository extends JpaRepository<ExtraOption, Long> {

    List<ExtraOption> findAllByExtraOptionCategory(ExtraOptionCategory extraOptionCategory);
}

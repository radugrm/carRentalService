package com.raflo.rentalService.controllers.dto;

public class DeleteExtraOptionFormDto {
    public static final String DELETE_EXTRA_OPTION_FORM = "deleteExtraOptionForm";

    private Long id;

    public Long getExtraOptionId() {
        return id;
    }

    public void setExtraOptionId(Long id) {
        this.id = id;
    }
}

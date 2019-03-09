package com.raflo.rentalService.model;

import javax.persistence.*;

@Entity
@Table(name = "EXTRAOPTIONS")
public class ExtraOption {

    @Id
    @GeneratedValue
    private long id;

    @Column (name = "category")
    private ExtraOptionCategoryEnum extraOptionCategoryEnum;

    @Column (name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExtraOptionCategoryEnum getExtraOptionCategoryEnum() {
        return extraOptionCategoryEnum;
    }

    public void setExtraOptionCategoryEnum(ExtraOptionCategoryEnum extraOptionCategoryEnum) {
        this.extraOptionCategoryEnum = extraOptionCategoryEnum;
        switch (extraOptionCategoryEnum){
            case TODDLER_SEAT:
                this.price=15;
                break;
            case NAVIGATION:
                this.price=10;
                break;
            case INSURANCE:
                this.price=20;
                break;
            case ADDITIONAL_DRIVER:
                this.price=15;
                break;
        }
    }


    public int getPrice() {
        return price;
    }


}

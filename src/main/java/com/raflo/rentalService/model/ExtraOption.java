package com.raflo.rentalService.model;

import javax.persistence.*;
import java.util.Comparator;

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

    @Column (name = "availability")
    private boolean availability;

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
            case INFANT_SEAT:
                this.price=15;
                break;
            case NAVIGATION:
                this.price=10;
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean available) {
        this.availability = available;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public int getPrice() {
        return price;
    }

    public String getAvailabilityToString(){
        if(this.availability) return "available";
        else return "unavailable";
    }
}

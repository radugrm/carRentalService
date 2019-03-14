package com.raflo.rentalService.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

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

    @OneToMany(mappedBy = "extraOption")
    private List<Rental> rentals;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

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


    public int getPrice() {
        return price;
    }

    public String getAvailabilityToString(){
        if(this.availability) return "available";
        else return "unavailable";
    }
}

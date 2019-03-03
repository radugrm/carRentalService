package com.raflo.rentalService.model;

import javax.persistence.*;

@Entity
@Table (name = "CARS")
public class Car {

    @Id
    @GeneratedValue
    private long id;

    @Column (name = "brand")
    private String brand;

    @Column (name = "model")
    private String model;

    @Column (name = "category")
    private CarCategory carCategory;

    @Column (name = "number_plate")
    private String numberPlate;

    @Column (name = "price")
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
        switch (carCategory){
            case ECONOMY:
                this.price=35;
                break;
            case REGULAR:
                this.price=45;
                break;
            case LUXURY:
                this.price=70;
                break;
            case SUV:
                this.price=60;
                break;
        }
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPrice() {
        return price;
    }


}

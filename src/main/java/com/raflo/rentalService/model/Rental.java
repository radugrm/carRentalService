package com.raflo.rentalService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RENTAL")
public class Rental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name="total_price")
    private int totalPrice;

    @OneToMany(mappedBy = "rental",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<ExtraOption> extraOptions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<ExtraOption> getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(List<ExtraOption> extraOptions) {
        this.extraOptions = extraOptions;
        for( ExtraOption extraOption:extraOptions) {
            this.totalPrice += extraOption.getPrice();
        }
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

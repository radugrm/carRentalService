package com.raflo.rentalService.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "RENTAL")
public class Rental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "insurance")
    private boolean insurance;

    @Column(name = "additional_driver")
    private int additionalDriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "extraoptions_rental",
            joinColumns = @JoinColumn(name = "extraoption_id"),
            inverseJoinColumns = @JoinColumn(name = "rental_id")
    )
    private Set<ExtraOption> extraOptions = new HashSet<>();

    @Column(name = "total_price")
    private int totalPrice;


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public int getAdditionalDriver() {
        return additionalDriver;
    }

    public void setAdditionalDriver(int additionalDriver) {
        this.additionalDriver = additionalDriver;
    }

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


    public Set<ExtraOption> getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(Set<ExtraOption> extraOptions) {
        this.extraOptions = extraOptions;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }




}

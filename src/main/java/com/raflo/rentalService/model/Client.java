package com.raflo.rentalService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "CNP")
    private String cnp;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + ' ' +
                 lastName;
    }
}

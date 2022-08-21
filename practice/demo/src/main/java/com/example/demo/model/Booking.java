package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Booking_info")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String user;

    public String vaccine;
    public String date;


    public Booking(){

    }
    public Booking(String user, String vaccine, String date) {
        this.user = user;
        this.vaccine = vaccine;
        this.date = date;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVaccine() {
        return vaccine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

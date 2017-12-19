package com.ivanchez.videogamesapi;

import java.util.UUID;

public class Console {
    private String id;
    private String name;
    private String company;
    private int year;

    public Console(String name, String company, int year) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.company = company;
        this.year = year;
    }

    public Console(Console console) {
        this.id = UUID.randomUUID().toString();
        this.name = console.getName();
        this.company = console.getCompany();
        this.year = console.getYear();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Id: " + this.id + "\nName: " + this.name + "\nCompany: " + this.company + "\nYear: " + this.year;
    }
}
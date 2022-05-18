package com.example.md4thuchanh.model;

import javax.persistence.*;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long acreage;
    private Long population;
    private Long jdp;
    private String describe1;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Province() {
    }

    public Province(String name, Long acreage, Long population, Long jdp, String describe, Country country) {
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.jdp = jdp;
        this.describe1 = describe;
        this.country = country;
    }

    public Province(Long id, String name, Long acreage, Long population, Long jdp, String describe, Country country) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.jdp = jdp;
        this.describe1 = describe;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAcreage() {
        return acreage;
    }

    public void setAcreage(Long acreage) {
        this.acreage = acreage;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getJdp() {
        return jdp;
    }

    public void setJdp(Long jdp) {
        this.jdp = jdp;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

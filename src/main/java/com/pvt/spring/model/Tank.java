package com.pvt.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="tank")
public class Tank implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column
    private String country;
    @Column
	private String name;
    @Column
	private Integer year;
        
    public Tank() {

    }

    public Tank(Long id, String country, String name, Integer year) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Tank{" + "country=" + country + ", name=" + name + '}';
    }

}
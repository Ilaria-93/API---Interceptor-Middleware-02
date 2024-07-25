package com.example.InterceptorMiddlewareApplication2.entities;

import jakarta.persistence.*;

@Entity
public class Month {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "month_number", nullable = false)
    private Integer monthNumber;

    @Column(name = "english_name", nullable = false)
    private String englishName;

    @Column(name = "italian_name", nullable = false)
    private String italianName;

    @Column(name = "german_name", nullable = false)
    private String germanName;

    public Month() {

    }

    public Month(Integer id, Integer monthNumber, String englishName, String italianName, String germanName) {
        this.id = id;
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }
}

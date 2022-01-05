package com.example.spring_tutorial.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double total;
    private double totalPayer;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "commande")
    private List<Paiment> paiments;

    public List<Paiment> getPaiments() {
        return paiments;
    }

    public void setPaiments(List<Paiment> paiments) {
        this.paiments = paiments;
    }

    public Commande() {

    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", total=" + total +
                ", totalPayer=" + totalPayer +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPayer() {
        return totalPayer;
    }

    public void setTotalPayer(double totalPayer) {
        this.totalPayer = totalPayer;
    }
}

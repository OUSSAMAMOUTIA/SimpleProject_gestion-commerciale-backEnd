package com.example.spring_tutorial.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double total;
    private double totalPayer;

    public Commande(Long id, String reference, double total, double totalPayer) {
        this.id = id;
        this.reference = reference;
        this.total = total;
        this.totalPayer = totalPayer;
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

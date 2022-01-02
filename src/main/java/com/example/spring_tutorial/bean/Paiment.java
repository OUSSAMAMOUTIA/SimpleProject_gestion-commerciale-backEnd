package com.example.spring_tutorial.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Paiment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String code;
    public double montant;
    public Date datePaiment;
    @ManyToOne
    private Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Paiment(Long id, String code, double montant, Date datePaiment) {
        this.id = id;
        this.code = code;
        this.montant = montant;
        this.datePaiment = datePaiment;
    }

    public Paiment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiment() {
        return datePaiment;
    }

    public void setDatePaiment(Date datePaiment) {
        this.datePaiment = datePaiment;
    }

}

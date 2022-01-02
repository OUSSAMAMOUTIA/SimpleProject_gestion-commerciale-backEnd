package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.bean.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentDao extends JpaRepository<Paiment,Long> {
    public Paiment findByCode(String code);
    public List<Paiment> findByCommandeReference(String reference);
    public int deleteByCommandeReference(String reference);
    @Query("SELECT p FROM Paiment p WHERE p.commande.reference=:reference AND p.commande.total<p.commande.totalPayer")
    public List<Paiment> findCommandeNonPayer(@Param("reference") String reference);
}

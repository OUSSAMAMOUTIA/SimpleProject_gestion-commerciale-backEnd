package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {
    public Commande findByReference(String reference);
    @Query("SELECT c FROM Commande c WHERE c.total =?1 ORDER BY c.total DESC")
    public List<Commande> findByTotalSorted(double total );
    public int deleteByReference(String reference);


}

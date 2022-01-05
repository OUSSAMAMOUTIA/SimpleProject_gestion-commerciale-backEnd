package com.example.spring_tutorial.service;

import com.example.spring_tutorial.bean.Commande;
import com.example.spring_tutorial.bean.Paiment;
import com.example.spring_tutorial.dao.PaimentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaimentService {
    @Autowired
    private PaimentDao paimentDao;
    @Autowired
    private CommandeService commandeService;
    public Paiment findByCode(String code) {
        return paimentDao.findByCode(code);
    }

    public List<Paiment> findByCommandeReference(String reference) {
        return paimentDao.findByCommandeReference(reference);
    }
    @Transactional
    public int deleteByCommandeReference(String reference) {
        return paimentDao.deleteByCommandeReference(reference);
    }
    @Transactional
    public int deleteByCode(String code) {
        return paimentDao.deleteByCode(code);
    }

    public List<Paiment> findCommandeNonPayer(String reference) {
        return paimentDao.findCommandeNonPayer(reference);
    }

    public List<Paiment> findAll() {
        return paimentDao.findAll();
    }
    public int save(Paiment paiment){
        if(findByCode(paiment.getCode())!=null){
            return -1;
        }
        Commande commande = commandeService.findByReference(paiment.getCommande().getReference());
        paiment.setCommande(commande);
         if(commande==null){
            return -2;
        }
        else if(paiment.getMontant()+commande.getTotalPayer()>commande.getTotal()){
            return -3;
        }
        else{
            double nv =paiment.getMontant()+commande.getTotalPayer();
            commande.setTotalPayer(nv);
            commandeService.update(commande);
            paimentDao.save(paiment);
            return 1;
         }
    }
    public void update(Paiment paiment){
       paimentDao.save(paiment);
    }
    public void save(Commande commande, List<Paiment> paiments) {
        for (Paiment paiment:paiments) {
           double nv = paiment.getMontant()+commande.getTotalPayer();
           commande.setTotalPayer(nv);
           paiment.setCommande(commande);
           paimentDao.save(paiment);
        }
    }
}

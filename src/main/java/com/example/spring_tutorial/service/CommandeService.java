package com.example.spring_tutorial.service;

import com.example.spring_tutorial.bean.Commande;
import com.example.spring_tutorial.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private  PaimentService paimentService;

    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }
    public List<Commande> findByTotalSorted(double total) {
        return commandeDao.findByTotalSorted(total);
    }
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
    public int save(Commande commande){
        if(findByReference(commande.getReference())!=null){
            return -1;
        }
        else if(commande.getTotal()<commande.getTotalPayer()){
            return -2;
        }
        else{
            commandeDao.save(commande);
            paimentService.save(commande,commande.getPaiments());
            return  1;
        }
    }
    public int payer(String reference,double montantAPayer){
        if(findByReference(reference)==null){
            return -1;
        }else if(findByReference(reference).getTotalPayer()+montantAPayer>findByReference(reference).getTotal()){
            return -2;
        }else{
            double nv =findByReference(reference).getTotalPayer()+montantAPayer;
            findByReference(reference).setTotalPayer(nv);
            commandeDao.save(findByReference(reference));
            return 1;
        }
    }
    public void update(Commande commande){
        commandeDao.save(commande);
    }
    public void changeCommande(Commande commande){
        commandeDao.save(commande);
        paimentService.save(commande,commande.getPaiments());
    }
    @Transactional
    public int deleteByReference(String reference) {
        if(findByReference(reference)==null){
            return -1;
        }else{
            int paiment = paimentService.deleteByCommandeReference(reference);
            int commande = commandeDao.deleteByReference(reference);
            return commande+paiment;
        }

    }
}

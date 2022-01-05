package com.example.spring_tutorial.ws;

import com.example.spring_tutorial.bean.Commande;
import com.example.spring_tutorial.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("gestion_commande/commande")
public class CommandeWs {
    @Autowired
    private CommandeService commandeService;
    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }
    @GetMapping("/total/{total}")
    public List<Commande> findByTotalSorted(@PathVariable double total) {
        return commandeService.findByTotalSorted(total);
    }
    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
    @PutMapping("/payer/reference/{reference}/montant/{montantAPayer}")
    public int payer(@PathVariable String reference,@PathVariable double montantAPayer) {
        return commandeService.payer(reference, montantAPayer);
    }
    @PutMapping("/")
    public void changeCommande(@RequestBody Commande commande) {
        commandeService.changeCommande(commande);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }
}

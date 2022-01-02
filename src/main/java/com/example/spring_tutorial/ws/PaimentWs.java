package com.example.spring_tutorial.ws;

import com.example.spring_tutorial.bean.Paiment;
import com.example.spring_tutorial.service.PaimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion_commande/paiment")
public class PaimentWs {
    @Autowired
    private PaimentService paimentService;
    @GetMapping("/code/{code}")
    public Paiment findByCode(@PathVariable String code) {
        return paimentService.findByCode(code);
    }
    @GetMapping("/commande/reference/{reference}")
    public List<Paiment> findByCommandeReference(@PathVariable String reference) {
        return paimentService.findByCommandeReference(reference);
    }

    @DeleteMapping("/commande/reference/{reference}")
    public int deleteByCommandeReference(@PathVariable String reference) {
        return paimentService.deleteByCommandeReference(reference);
    }
    @GetMapping("/commande-non-paye/{reference}")
    public List<Paiment> findCommandeNonPayer(@PathVariable String reference) {
        return paimentService.findCommandeNonPayer(reference);
    }
    @GetMapping("/")
    public List<Paiment> findAll() {
        return paimentService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Paiment paiment) {
        return paimentService.save(paiment);
    }
}

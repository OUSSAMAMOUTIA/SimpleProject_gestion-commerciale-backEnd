package com.example.spring_tutorial.ws;

import com.example.spring_tutorial.bean.Paiment;
import com.example.spring_tutorial.service.PaimentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paimentService.deleteByCode(code);
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
    @PutMapping("/")
    public void update(@RequestBody Paiment paiment) {
        paimentService.update(paiment);
    }
}

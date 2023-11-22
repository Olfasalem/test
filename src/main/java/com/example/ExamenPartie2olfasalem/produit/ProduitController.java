package com.example.ExamenPartie2olfasalem.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/produit")
public class ProduitController {



        private final ProduitService produitService;

        @Autowired
        public ProduitController(ProduitService produitService) {
            this.produitService = produitService;
        }

        @GetMapping
        public List<produit> getProduit() {
            return produitService.getProduit();
        }

        @PostMapping()
        public void newProduit(@RequestBody produit p) {


            produitService.addProduit(p);
        }
        @DeleteMapping(path = "{ProdId}")
        public void deleteProduit(@PathVariable("ProdId") int id) {
            produitService.deleteProduit(id);
        }

        @GetMapping("/{ProdId}")
        public ResponseEntity<produit> getProduit(@PathVariable("ProdId") int id) {
            produit produit = produitService.getProduitById(id);
            if (produit != null) {
                return ResponseEntity.ok(produit);
            } else {
                return ResponseEntity.notFound().build();
            }




            }
        }











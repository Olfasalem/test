package com.example.ExamenPartie2olfasalem.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService {





        private final produitRepository produitRepository;

        @Autowired
        public ProduitService(produitRepository produitRepository) {
            this.produitRepository = produitRepository;
        }


        public List<produit> getProduit() {
            return produitRepository.findAll();
        }

        public void addProduit(produit p) {

            produitRepository.save(p);
        }

        public void deleteProduit(int id) {
            produitRepository.deleteById(id);
        }
        public produit getProduitById(int id) {

            return produitRepository.findById(id).orElse(null);
        }


    }










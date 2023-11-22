package com.example.ExamenPartie2olfasalem.produit;

import jakarta.persistence.*;



@Entity
@Table(name = "produits")
public class produit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_SEQ")
    @SequenceGenerator(name = "users_SEQ", sequenceName = "produits_id_seq", allocationSize = 1)

    @Column(name = "id")

    private  int id;
    private String nom;

    private String  description;
    private  int prix;

    public produit() {
    }

    public produit(int id, String nom, String description, int prix) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id= id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "produit{" +
                "ProdId=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}

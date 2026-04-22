package com.example.projetws.models;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private String sexe;

    // Constructeur vide (requis par Gson)
    public Etudiant() {}

    // Constructeur complet
    public Etudiant(int id, String nom, String prenom, String ville, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.sexe = sexe;
    }

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getVille() { return ville; }
    public String getSexe() { return sexe; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setVille(String ville) { this.ville = ville; }
    public void setSexe(String sexe) { this.sexe = sexe; }
}
package com.example.horrorgame;

public class Item {
    private String nom;
    private double poids;
    private boolean empilable;

    public Item(String nom, double poids, boolean empilable) {
        this.nom = nom;
        this.poids = poids;
        this.empilable = empilable;
    }

    public String getNom() {
        return nom;
    }

    public double getPoids() {
        return poids;
    }

    public boolean estEmpilable() {
        return empilable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item autre = (Item) obj;
        return nom.equals(autre.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return nom;
    }
}
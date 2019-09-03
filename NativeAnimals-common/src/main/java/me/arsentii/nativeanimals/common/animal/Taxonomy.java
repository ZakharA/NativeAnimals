/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.animal;

/**
 *
 * @author zakhar
 */
public class Taxonomy {
    private String kingdom;
    private String phylum;
    private String animal_class;
    private String order;
    private String family;
    private String genus;
    private String species;

    public Taxonomy() {
    }

    public Taxonomy(String kingdom, String phylum, String animal_class, String order, String family, String genus, String species) {
        this.kingdom = kingdom;
        this.phylum = phylum;
        this.animal_class = animal_class;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getAnimal_class() {
        return animal_class;
    }

    public void setAnimal_class(String animal_class) {
        this.animal_class = animal_class;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
}

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
enum Diet {

    CARNIVORES,
    HERBIVORES,
    OMNIVORES
}

enum Status {
    ENDANGERED,
    THREATENED,
    VULNERABLE
}

enum Continent {

    AFRICA,
    ASIA,
    AUSTRALIA,
    EUROPE,
    NORTHAMERICA,
    SOUTHAMERICA
}

enum Habitat {
    DESERTS,
    GRASSLANDS,
    FORESTS,
    MOUNTAINS,
    FRESHWATER,
    OCEANS,
    TUNDRA
}

public class Animal {
    private Long id;
    private String scientificName;
    private String commonName;
    private Taxonomy taxonomy;
    private Diet diet;
    private String description;
    private Status status;
    private byte[] image;
    private Continent continent;
    private Habitat habitat;

    public Animal() {
    }

    public Animal(Long id, String scientificName, String commonName, 
                    Taxonomy taxonomy, Diet diet, String description, 
                    Status status, byte[] image, Continent continent, 
                    Habitat habitat) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.taxonomy = taxonomy;
        this.diet = diet;
        this.description = description;
        this.status = status;
        this.image = image;
        this.continent = continent;
        this.habitat = habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + 
                        ", scientificName=" + scientificName + 
                        ", commonName=" + commonName + 
                        ", taxonomy=" + taxonomy + 
                        ", diet=" + diet + 
                        ", description=" + description + 
                        ", status=" + status + 
                        ", image=" + image + 
                        ", continent=" + continent + 
                        ", habitat=" + habitat + '}';
    }
    
    
    
}

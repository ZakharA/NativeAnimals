/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.common.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

@Entity
@NamedQueries({
    @NamedQuery(name = Animal.GET_ALL_QUERY_NAME, query = "SELECT a FROM Animal a"),
    @NamedQuery(name = Animal.FIND_BY_NAME_QUERY_NAME, query = "SELECT a FROM Animal a WHERE lower(a.commonName) LIKE lower(concat('%', :commonName, '%'))")
})
public class Animal implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "Animal.getAll";
    public static final String FIND_BY_NAME_QUERY_NAME = "Animal.findByCommonName";

    @Id
    @GeneratedValue
    private Long id;
    private String scientificName;
    @NotNull
    private String commonName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Diet diet;
    @NotNull
    @Size(min = 10, max = 2000)
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    private String image;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Continent continent;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Habitat habitat;
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public Animal() {
    }

    public Animal(Long id, String scientificName, String commonName,
            Diet diet, String description,
            Status status, String image, Continent continent,
            Habitat habitat, Date creationDate) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.diet = diet;
        this.description = description;
        this.status = status;
        this.image = image;
        this.continent = continent;
        this.habitat = habitat;
        this.creationDate = creationDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
        return "Animal{" + "id=" + id
                + ", scientificName=" + scientificName
                + ", commonName=" + commonName
                + ", diet=" + diet
                + ", description=" + description
                + ", status=" + status
                + ", image=" + image
                + ", continent=" + continent
                + ", habitat=" + habitat + '}';
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

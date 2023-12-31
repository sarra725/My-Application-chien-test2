package com.example.myapplicationtest2;

public class Chien {
    private String imageName;
    private String name;
    private String breed;
    private String country;
    private String description;

    public Chien(String imageName, String name, String breed, String country, String description) {
        this.imageName = imageName;
        this.name = name;
        this.breed = breed;
        this.country = country;
        this.description = description;
    }
// les getters sont utilisés pour récupérer la valeur des champs privés de l'objet,
// ses propriétés ne peuvent pas être modifiées.
    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() { return description;}
}

package com.example.dogsapi;

public class Dog {
    private String name;
    private int coatLength;
    private int trainability;
    private int energy;
    private int minLifeExpectancy;
    private int maxLifeExpectancy;
    private String imageUrl;

    // Constructor
    public Dog(String name, int coatLength, int trainability, int energy, int minLifeExpectancy, int maxLifeExpectancy, String imageUrl) {
        this.name = name;
        this.coatLength = coatLength;
        this.trainability = trainability;
        this.energy = energy;
        this.minLifeExpectancy = minLifeExpectancy;
        this.maxLifeExpectancy = maxLifeExpectancy;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters

    // Accessor methods for 'name'
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Accessor methods for 'coatLength'
    public int getCoatLength() {
        return coatLength;
    }
    public void setCoatLength(int coatLength) {
        this.coatLength = coatLength;
    }

    // Accessor methods for 'trainability', 'energy', 'minLifeExpectancy', 'maxLifeExpectancy'
    public int getTrainability() {
        return trainability;
    }
    public void setTrainability(int trainability) {
        this.trainability = trainability;
    }

    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMinLifeExpectancy() {
        return minLifeExpectancy;
    }
    public void setMinLifeExpectancy(int minLifeExpectancy) {
        this.minLifeExpectancy = minLifeExpectancy;
    }

    public int getMaxLifeExpectancy() {
        return maxLifeExpectancy;
    }
    public void setMaxLifeExpectancy(int maxLifeExpectancy) {
        this.maxLifeExpectancy = maxLifeExpectancy;
    }

    // Accessor methods for 'imageUrl'
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // toString() method for string representation
    @Override
    public String toString() {
        return name;
    }
}

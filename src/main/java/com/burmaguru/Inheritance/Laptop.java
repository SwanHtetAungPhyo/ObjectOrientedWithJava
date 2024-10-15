package com.burmaguru.Inheritance;

public class Laptop extends Computer{
    private double weight;
    private boolean hasTouchScreen;
    public Laptop(String brandName, String processor, int ram, double weight, boolean hashTouchScreen) {
        super(brandName, processor, ram);
        this.weight = weight;
        this.hasTouchScreen = hashTouchScreen;
    }

    @Override
    public void displaySpec(){
        super.displaySpec();
        System.out.println("Weight: " + weight);
        System.out.println("HasTouchScreen" + hasTouchScreen);
    }

}

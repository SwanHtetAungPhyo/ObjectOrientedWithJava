package com.burmaguru.Inheritance;

public class Application {

    public static void main(String[] args) {
        Laptop laptop = new Laptop("MAC", "M3",16,3.0,false);
        Desktop desktop = new Desktop("Acer", "i9",32,"Tower");

        laptop.displaySpec();
        System.out.println("\n");
        desktop.displaySpec();

        System.out.println(laptop.getBrandName());
        System.out.println(laptop.getProcessor());
    }
}

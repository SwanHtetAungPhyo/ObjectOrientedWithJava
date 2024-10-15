package com.burmaguru.Inheritance;

public class Computer {
    private String brandName;
    private String processor;
    private int ram;

    public Computer(String brandName, String processor, int ram) {
        this.brandName = brandName;
        this.processor = processor;
        this.ram = ram;
    }

    public void displaySpec(){
        System.out.println("Brand: " + brandName);
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + " GB");
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
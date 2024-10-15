package com.burmaguru.Inheritance;

public class Desktop extends Computer{
    private String formFactor;  // Stand and all

    public Desktop(String brandName, String processor, int ram, String formfactor) {
        super(brandName, processor, ram);
        this.formFactor = formfactor;
    }

    @Override
    public  void displaySpec(){
        super.displaySpec();
        System.out.println("FormFactor" + formFactor);
    }


}

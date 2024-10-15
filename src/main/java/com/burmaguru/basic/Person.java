package com.burmaguru.basic;

import java.util.Objects;

/**
 * @class Person
 */
public class Person {

    //Fields
    private int age;
    private String name;

    // Constructor Overloading can make the initialization of the Objects to be more flexible
    // When you have the user data which can be updated later, you can call just the field which you need
    public Person(){

    }

    public Person(int age){
        this(age, null);
    }
    public Person( String name){
        this(0, name);
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return  this.age;
    }

    public String getName(){
        return  this.name;
    }

    public void  setAge(int age){
        if(age < 0){
            throw  new IllegalArgumentException("Invalid Age");
        }
        this.age = age;
    }

    public void setName(String name){
        this.name  = name;
    }

    /**
     * Checks if this object is equal to another object.
     *
     * @param o the object to compare with
     * @return true if this object is the same as the object passed as parameter, false otherwise
     * <p>
     * This method overrides the default implementation of equals and compares the
     * current object with another object of type Person. The comparison checks if
     * the age and name fields are equal between the two objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    /**
     * Generates a hash code for this object.
     *
     * @return an integer representing the hash code for this object
     * <p>
     * This method overrides the default implementation of hashCode and computes
     * a hash code based on the age and name fields. The hash code is generated using
     * the built-in `Objects.hash` method.
     */
    @Override
    public  int hashCode(){
        return  Objects.hash(age, name);
    }
}

package com.burmaguru.basic;

/**
 *
 */
public class Application {
    public static void main(String[] args) {
        Person person = new Person(10);
        Person person1 = new Person("Jame");
        Person person3 = new Person(10, "JameJoke");

        Person person2 = new Person(10);

        Application.equalMeanShallowComparision(person3, person1);

        System.out.println(person1.hashCode());
    }

    /**
     * @brief With the help of the equal method , we can make the shallow comparison between 2 objects
     *
     */
    public  static  void    equalMeanShallowComparision(Object obj, Object obj2){
        if(obj.equals(obj2)){
            System.out.println("They are the same");
        }else{
            System.out.println("They are not the same");
        }


    }
}


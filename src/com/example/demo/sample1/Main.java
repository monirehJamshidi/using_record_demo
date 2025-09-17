package com.example.demo.sample1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Monireh", 25);
        System.out.println(person.name()); // Monirehh
        System.out.println(person.age()); // 25
        System.out.println(person.toString()); //Person[name=Monireh, age=25]
    }

}

package com.example.demo.sample4;

public class Main {
    public static void main(String[] args) {

        record Person(String name, String family){}

        Person person = new Person("Monireh", "Jamshidi");
    }
}

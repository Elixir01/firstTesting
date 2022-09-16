package com.testing.testing.lambdaexpression;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    public enum Sex{
        MALE, FEMALE
    }

    String name;
    int age;
    String emailAddress;
    Sex gender;

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static List<Person> generateDefaultList(){
     List<Person> people = new ArrayList<>();
     people.add(new Person("Amrit",10, "abohara706@gmail.com",Sex.MALE));
     people.add(new Person("Bohara",20, "bohara@gmail.com",Sex.MALE));
     people.add(new Person("Harry",30, "harry@gmail.com",Sex.MALE));
     people.add(new Person("Parrot",19, "parrot@gmail.com",Sex.FEMALE));
     people.add(new Person("Taylor",50, "taylor@gmail.com",Sex.FEMALE));
     return people;
    }

}

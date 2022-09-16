package com.testing.testing.lambdaexpression;

import java.util.List;
import java.util.function.Predicate;

public class Main {

        /*public static void printPerson(List<Person> people, int age){
         for(Person p: people){
             if(p.getAge() >= age){
                 p.printPerson();
             }
         }
        }*/

    public static void printPersonOfCertainAge(List<Person> people, int low, int high) {
        for (Person p : people) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPeople(List<Person> people, CheckPerson tester) {
        for (Person p : people) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }

    }

    public static void printPeopleWithPredicate(List<Person> people, Predicate<Person> tester) {
        for (Person p : people) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }

    }

    public static void main(String[] args) {

        //user wants the data based on multiple fields???
        List<Person> people = Person.generateDefaultList();
        //printPerson(people, 20);
        //printPersonOfCertainAge(people, 20, 30);
        printPeople(people,
                    new CheckPersonEligibleForSelectiveSearch());

        //directly call the anonymous class without creating new CheckPersonEligibleForSeleciveSearch class
        printPeople(people,
                    new CheckPerson() {
                        @Override
                        public boolean test(Person p) {
                            return p.gender == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25;
                        }
                    });

        //directly create lambda expression and use the functionality
        printPeopleWithPredicate(people, p -> p.gender == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25);

    }

}


/*
NOTE:
you dont have to create interface
you don't have to create classes
you don't have to create methods
        nothing
        just use the default interfaces available
        leverage those and if they are not available you have custom implementation
        if you need then you can create the
custom class interfaces as well that will behave according to your business logic.*/

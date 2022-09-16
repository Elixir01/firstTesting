package com.testing.testing.lambdaexpression;

public class CheckPersonEligibleForSelectiveSearch implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
}

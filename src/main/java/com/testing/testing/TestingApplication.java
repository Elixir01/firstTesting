package com.testing.testing;

import com.testing.testing.streamApi.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TestingApplication {

    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("Amrit",
                                   "Bohara",
                                   5000.0,
                                   List.of("Project 1",
                                           "Project 2")));
        employees.add(new Employee("Sweta",
                                   "Bajracharya",
                                   55000.0,
                                   List.of("Project 1",
                                           "Project 3")));
        employees.add(new Employee("Avinash",
                                   "Misra",
                                   4500.0,
                                   List.of("Project 3",
                                           "Project 4")));
    }

    public static void main(String[] args) {
        //SpringApplication.run(TestingApplication.class, args);

        //foreach
        employees.stream()
                 .forEach(employee -> System.out.println(employee));
        //map
        //collect
        Set<Employee> increasedSalary = employees.stream()
                                                 .map(employee -> new Employee(employee.getFirstName(),
                                                                               employee.getLastName(),
                                                                               employee.getSalary() * 1.10,
                                                                               employee.getProject()))
                                                 .collect(Collectors.toSet());
        System.out.println(increasedSalary);

        //filter
        List<Employee> filterEmployee = employees.stream()
                                                 .filter(employee -> employee.getSalary() > 5000)
                                                 .map(employee -> new Employee(employee.getFirstName(),
                                                                               employee.getLastName(),
                                                                               employee.getSalary() * 1.10,
                                                                               employee.getProject()))
                                                 .collect(Collectors.toList());
        System.out.println(filterEmployee);


        //findFirst
        Employee firstEmployee = employees.stream()
                                          .filter(employee -> employee.getSalary() > 500000)
                                          .map(employee -> new Employee(employee.getFirstName(),
                                                                        employee.getLastName(),
                                                                        employee.getSalary() * 1.10,
                                                                        employee.getProject()))
                                          .findFirst()
                                          .orElse(null);
        System.out.println(firstEmployee);

        //flatMap
        String projects = employees.stream()
                                   .map(employee -> employee.getProject())
                                   .flatMap(strings -> strings.stream())
                                   .collect(Collectors.joining(","));
        System.out.println(projects);


        //short Circuit operations
        List<Employee> shortCircuit = employees.stream()
                                               .skip(1)
                                               .limit(1)
                                               .collect(Collectors.toList());
        System.out.println(shortCircuit);


        //Finite Data
        Stream.generate(Math::random)
              .limit(5)
              .forEach(value -> System.out.println(value));

        //sorting
        List<Employee> sortedEmployees = employees.stream()
                                                  .sorted((o1, o2) -> o1.getFirstName()
                                                                        .compareToIgnoreCase(o2.getFirstName()))
                                                  .collect(Collectors.toList());
        System.out.println(sortedEmployees);

        //mix or min
        employees.stream()
                 .max(Comparator.comparing(Employee::getSalary))
                 .orElseThrow(NoSuchElementException::new);

        //reduce to accumulate as sum
        Double totalSal = employees.stream()
                                   .map(employee -> employee.getSalary())
                                   .reduce(0.0,
                                           Double::sum);
        System.out.println(totalSal);


        /*NOTE: you can also do parallelstream if you have to instanceof sequential stream.
        LazyImplementation means that all the operators wont run until and unless there is terminal operators
        flatMap -> it flatens the initial order and provides the result of the actual content.


        types of operators:
        terminal operators: you cant do any operation after terminal operations.
        intermediate operators: any operation that is returning stream itself is intermediate operation
        short circuit operators: it will limit your data, skip(),limit().*/


    }

}

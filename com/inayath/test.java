package com.inayath;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        System.out.println("First repeating character in a string");

        Set<Character> set=new HashSet<>();
        "adffda".chars().forEach(c->System.out.println(c +"--"+ (char)c));

        "adffda".chars().filter(i->!set.add((char)i)).forEach(System.out::println);

        //Can't use like below
       // "adffda".chars().filter(i->!set.add((char)i)).collect(Collectors.toList());



//        "adffda".chars()
//
//                .filter(c->!set.add((char)c))
//
//                .findFirst()
//
//                .ifPresent(ch->System.out.print((char)ch));
    }
}


/*

  java.util.stream
public final class Collectors
Implementations of Collector that implement various useful reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
        The following are examples of using the predefined collectors to perform common mutable reduction tasks:
        // Accumulate names into a List
        List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
        // Accumulate names into a TreeSet
         Set<String> set = people.stream()    .map(Person::getName)    .collect(Collectors.toCollection(TreeSet::new));
        // Convert elements to strings and concatenate them, separated by commas  String joined = things.stream()    .map(Object::toString)    .collect(Collectors.joining(", "));
        // Compute sum of salaries of employee
         int total = employees.stream()    .collect(Collectors.summingInt(Employee::getSalary));
        // Group employees by department
        // Map<Department, List<Employee>> byDept = employees.stream()  .collect(Collectors.groupingBy(Employee::getDepartment));
        // Compute sum of salaries by department
        // Map<Department, Integer> totalByDept = employees.stream()    .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)));
        // Partition students into passing and failing
        // Map<Boolean, List<Student>> passingFailing = students.stream()    .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
*/
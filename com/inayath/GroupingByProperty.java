package com.inayath;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProperty {


    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 30)
        );

        Map<Integer, List<Person>> sameageMap = people.stream().collect(Collectors.groupingBy(Person::getAge));
        List<List<Person>> sameagePeopleList = sameageMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println(sameagePeopleList);

        sameagePeopleList.forEach(person->person.forEach(p-> System.out.println(p.getName())));



    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return this.name;
    }
}



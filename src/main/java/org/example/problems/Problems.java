package org.example.problems;

import org.example.util.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problems {

    public static void main(String[] args) {
        //frequencyOfChars("navab");
        highestPaid();
    }

    //program to find frequency of each characters in string
    public static void frequencyOfChars(String string) {
        char[] chars = string.toCharArray();

        Map<String, Long> result = Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    //find highest paid employee
    public static void highestPaid() {
        Employee emp1 = new Employee(001, 5000, "Ram", "HR");
        Employee emp2 = new Employee(002, 7000, "Suja", "Support");
        Employee emp3 = new Employee(004, 7500, "Sona", "Support");
        Employee emp4 = new Employee(003, 12000, "Tom", "IT");
        Employee emp5 = new Employee(003, 14000, "Dick", "IT");
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.reducing(BinaryOperator.maxBy(compareBySalary))));
        System.out.println(collect);

    }
}

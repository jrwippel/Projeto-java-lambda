package util;

import entities.Employee;

import java.util.function.Predicate;

public class EmployeePredicate implements Predicate <Employee> {
    @Override
    public boolean test(Employee employee){
        return employee.getSalary() >= 4500;
    }


}

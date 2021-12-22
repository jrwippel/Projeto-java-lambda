package service;

import entities.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeService {

    public double FilteredSum(List<Employee> employeeList, Predicate<Employee> criteria){

        double sum = 0;
        for (Employee p : employeeList){
            if (criteria.test(p)){
                sum += p.getSalary();
            }
        }
        return sum;
    }
}

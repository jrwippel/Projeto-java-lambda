package application;

import entities.Employee;
import service.EmployeeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Program {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter with the path and name CSV:");
        String strpath = sc.nextLine();
        System.out.println("Enter Salary:");
        double salary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(strpath))){

            List<Employee> employeeList = new ArrayList<>();
            String line = br.readLine();



            while (line != null ){
                String[] output = line.split(",");
                employeeList.add(new Employee(output[0], output[1], Double.parseDouble(output[2])));
                line = br.readLine();
            }

            double avg = employeeList.stream()
                    .map(p -> p.getSalary())
                    .reduce(0.0, (x,y) -> x + y) / employeeList.size();

            System.out.println("Average salary: " + String.format("%.2f", avg));

            EmployeeService employeeService = new EmployeeService();

            double sum = employeeService.FilteredSum(employeeList, p -> p.getName().charAt(0) == 'M');

            System.out.println("Sum salary(M): " + String.format("%.2f", sum));

            System.out.println("Email of people whose salary is more than: "+ String.format("%.2f", salary));

            List<String> names = employeeList.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(p -> p.getEmail()).sorted()
                    .collect(Collectors.toList());

            names.forEach(System.out::println);

        }catch (IOException e){
            System.out.println("Erro ao Ler arquivo");
        }








        sc.close();
    }
}

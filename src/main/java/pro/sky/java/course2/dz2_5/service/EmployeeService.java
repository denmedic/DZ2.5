package pro.sky.java.course2.dz2_5.service;

import pro.sky.java.course2.dz2_5.exeptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.dz2_5.exeptions.EmployeeNotFoundExeption;
import pro.sky.java.course2.dz2_5.exeptions.EmployeeStorageIsFullException;
import pro.sky.java.course2.dz2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee);
        return employee;

    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundExeption();
        }
        return employee;


    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }


}





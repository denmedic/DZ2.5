package pro.sky.java.course2.dz2_5.service;

import pro.sky.java.course2.dz2_5.exeptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.dz2_5.exeptions.EmployeeNotFoundExeption;
import pro.sky.java.course2.dz2_5.exeptions.EmployeeStorageIsFullException;
import pro.sky.java.course2.dz2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {
    private final Employee[] employees = new Employee[10];

    public Employee add(String firstNameEmployee, String lastNameEmployee){
        Employee employee = new Employee(firstNameEmployee, lastNameEmployee);
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i], employee)){
                throw new EmployeeAlreadyAddedException();
            }
            if (Objects.isNull(employees[i])){
                index = i;
                break;
            }
        }
        if (index != -1){
            employees[index] = employee;
        } else {
            throw new EmployeeStorageIsFullException();
        }
        return  employee;

    }
    public Employee remove(String firstNameEmployee, String lastNameEmployee){
        Employee employee = new Employee(firstNameEmployee, lastNameEmployee);
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i], employee)){
                employees[i] = null;
                return  employee;
            }
        }
        throw new EmployeeNotFoundExeption();

    }
    public Employee find(String firstNameEmployee, String lastNameEmployee){
        Employee employee = new Employee(firstNameEmployee, lastNameEmployee);
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i], employee)){
                return employee;
            }
        }
        throw new EmployeeNotFoundExeption();

    }

}





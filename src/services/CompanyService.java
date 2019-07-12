package services;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {

    private List<Employee> employeeRepository = new ArrayList<>();

    public void addEmployee(int companyId, int employeeId) {
        employeeRepository.add(new Employee(companyId, employeeId));
    }

    public boolean hasEmployeeId(int employeeId){
        return (employeeRepository.stream()
                .filter(e -> e.getEmployeeId() == employeeId)
                .count()) == 1;
    }
}

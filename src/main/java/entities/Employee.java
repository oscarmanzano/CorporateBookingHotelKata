package entities;

public class Employee {
    private int companyId;
    private int employeeId;

    public Employee(int companyId, int employeeId) {
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

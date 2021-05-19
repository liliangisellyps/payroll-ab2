package src.payment;

import src.employees.Employee;
import java.util.List;

public class Company extends Payroll{
    public String name;
    private Double number;
    private String id;
    private String address;
    public Company(Company company, Employee employee, Salary salary, List<String> schedule) {
        super();
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getNumber() {
        return number;
    }
    public void setNumber(Double number) {
        this.number = number;
    }
}

package src.employees;

import java.util.List;

import src.payment.Payment;

public class Commissioned extends Employee{
    private int salary;
    private int commission;
    private List<SaleReport> salesReport;
  
    
    public Commissioned(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType,
            String paymentDay, int salary, int commission, List<SaleReport> salesReport) {
        super(name, id, address, unionMember, payment, employeeType, paymentDay);
        this.salary = salary;
        this.commission = commission;
        this.salesReport = salesReport;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getComission() {
        return commission;
    }
    public void setComission(int commission) {
        this.commission = commission;
    }
    public List<SaleReport> getSalesReport() {
        return salesReport;
    }
    public void setSalesReport(List<SaleReport> salesReport) {
        this.salesReport = salesReport;
    }
    
}

package src.payment;


import src.employees.Employee;

public class Salary extends Payroll{
    public Double value;
    public Double normalTaxes;
    public Double extraHours;
    public Commissions comissions;
    public Salary(Company company, Employee employee, Salary salary, String schedule, Double value, Double normalTaxes,
            Double extraHours, Commissions comissions) {
        super(company, employee, salary, schedule);
        this.value = value;
        this.normalTaxes = normalTaxes;
        this.extraHours = extraHours;
        this.comissions = comissions;
    }
    public Salary(Company company, Employee employee, Salary salary, int schedule) {
    }

    public void setValue(Double value) {
        this.value = value;
    }
    public Double getValue() {
        return value;
    }
    public void setNormalTaxes(Double normalTaxes) {
        this.normalTaxes = normalTaxes;
    }
    public Double getNormalTaxes() {
        return normalTaxes;
    }
    public void setExtraHours(Double extraHours) {
        this.extraHours = extraHours;
    }
    public Double getExtraHours() {
        return extraHours;
    }
    public void setComissions(Commissions comissions) {
        this.comissions = comissions;
    }
    public Commissions getComissions() {
        return comissions;
    }
}

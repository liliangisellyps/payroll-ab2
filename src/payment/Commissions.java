package src.payment;

import java.time.LocalDate;

import src.employees.Employee;

public class Commissions extends Salary {
    private Double percentOfSales;
    private LocalDate dateOfSale;
    private Double priceOfSale;
    private Double commission;

    public Commissions(Company company, Employee employee, Salary salary, int schedule, Double percentOfSales,
            LocalDate dateOfSale, Double priceOfSale, Double commission) {
        super(company, employee, salary, schedule);
        this.percentOfSales = percentOfSales;
        this.dateOfSale = dateOfSale;
        this.priceOfSale = priceOfSale;
        this.commission = commission;
    }
    public Double getPercentOfSales() {
        return percentOfSales;
    }
    public Double getCommission() {
        return commission;
    }
    public void setCommission(Double commission) {
        this.commission = commission;
    }
    public Double getPriceOfSale() {
        return priceOfSale;
    }
    public void setPriceOfSale(Double priceOfSale) {
        this.priceOfSale = priceOfSale;
    }
    public LocalDate getDateOfSale() {
        return dateOfSale;
    }
    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }
    public void setPercentOfSales(Double percentOfSales) {
        this.percentOfSales = percentOfSales;
    }
}

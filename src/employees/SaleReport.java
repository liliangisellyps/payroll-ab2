package src.employees;

import java.time.LocalDate;

public class SaleReport {
    private LocalDate dateOfSale;
    private int priceOfSale;

    public SaleReport(LocalDate dateOfSale, int priceOfSale) {
        this.setDateOfSale(dateOfSale);
        this.setPriceOfSale(priceOfSale);
    }

    public int getPriceOfSale() {
        return priceOfSale;
    }

    public void setPriceOfSale(int priceOfSale) {
        this.priceOfSale = priceOfSale;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }
}

package src.employees;

public class UnionMember {
    private int monthlyTax;
    private int serviceTaxes;
    private int idUT;
    
    public UnionMember(int monthlyTax, int serviceTaxes, int idUT) {
        this.monthlyTax = monthlyTax;
        this.serviceTaxes = serviceTaxes;
        this.idUT = idUT;
    }
    public UnionMember(int serviceTaxes) {
        this.serviceTaxes = serviceTaxes;
    }
    public int getMonthlyTax() {
        return monthlyTax;
    }
    public void setMonthlyTax(int monthlyTax) {
        this.monthlyTax = monthlyTax;
    }

    public void setServiceTaxes(int serviceTaxes) {
        this.serviceTaxes = serviceTaxes;
    }

    public int getServiceTaxes() {
        return serviceTaxes;
    }

    public int getIdUT() {
        return idUT;
    }

    public void setIdUT(int idUT) {
        this.idUT = idUT;
    }
    
}

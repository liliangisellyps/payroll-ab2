package src.payment;

public class Payment {
    private int paymentMethod;
    private int bank;
    private int agency;
    private int account;

    public Payment(int paymentMethod, int bank2, int agency2, int account2) {
        this.setPaymentMethod(paymentMethod);
        this.setBank(bank2);
        this.setAgency(agency2);
        this.setAccount(account2);
    }

    public String paymentMethodToString() {
        if(this.getPaymentMethod() == 1) return "Mail Check";
        else if (this.getPaymentMethod() == 2) return "Hand Check";
        else if (this.getPaymentMethod() == 3) return "Bank Deposit";
        else return "Invalid";
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }    
}

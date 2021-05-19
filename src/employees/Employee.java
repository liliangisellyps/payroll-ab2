package src.employees;

import src.payment.Payment;

public class Employee {
    
    private String name;
    private int id;
    private String address;
    private UnionMember unionMember;
    private Payment payment;
    private int employeeType;
    private String paymentDay;


    public Employee(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType, String paymentDay) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.unionMember = unionMember;
        this.payment = payment;
        this.employeeType = employeeType;
        this.paymentDay = paymentDay;
    }

    public String employeeInfos(){
        return "Name: " + this.getName() + "\nID: " + this.getId() + "\nAddress: " + getAddress() + "\nEmployee Type: " + employeeTypeToString() + "\nPayment Day: " + getPaymentDay() + "\nIs Union Member? " + isUnionMember();
    }

    public String employeeTypeToString() {
        if(this.getEmployeeType() == 1) return "Salaried";
        else if (this.getEmployeeType() == 2) return "Commissioned";
        else if (this.getEmployeeType() == 3) return "Hourly";
        else return "Invalid";
    }

    public String isUnionMember() {
        if(this.getUnionMember().getIdUT() == 0) return "No.";
        else return "Yes."; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }

    // public String paymentDayToString() {
    //     if(this.getPaymentDay() == 1) return "Monthly";
    //     else if (this.getPaymentDay() == 2) return "Bi-Weekly";
    //     else if (this.getPaymentDay() == 3) return "Weekly";
    //     else return "Invalid";
    // }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UnionMember getUnionMember() {
        return unionMember;
    }

    public void setUnionMember(UnionMember unionMember) {
        this.unionMember = unionMember;
    }

    public Payment getPayment() {
        return payment;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public int getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

}

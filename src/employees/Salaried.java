package src.employees;

import src.payment.Payment;

public class Salaried extends Employee {
    private int salary;


    public Salaried(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType,
            String paymentDay, int salary) {
        super(name, id, address, unionMember, payment, employeeType, paymentDay);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

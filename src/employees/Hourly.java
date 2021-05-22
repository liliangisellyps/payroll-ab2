package src.employees;

import java.util.List;

import src.payment.Payment;

public class Hourly extends Employee {
    
    public Hourly(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType,
            String paymentDay, int hourSalary) {
        super(name, id, address, unionMember, payment, employeeType, paymentDay);
    }

    private List<TimeCard> timecard;

    public List<TimeCard> getTimecard() {
        return this.timecard;
    }
}

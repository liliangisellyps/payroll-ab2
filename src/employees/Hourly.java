package src.employees;

import java.util.List;

import src.payment.Payment;

public class Hourly extends Employee {
    private int hourSalary;
    
    public Hourly(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType,
            String paymentDay, int hourSalary) {
        super(name, id, address, unionMember, payment, employeeType, paymentDay);
        this.hourSalary = hourSalary;
    }

    private List<TimeCard> timecard;
    
    public int getHourSalary() {
        return hourSalary;
    }
 
    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }

    public List<TimeCard> getTimecard() {
        return this.timecard;
    }
 
    public void setTimecard(List<TimeCard> timecard) {
        this.timecard = timecard;
    }
}

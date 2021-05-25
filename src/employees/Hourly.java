package src.employees;

import java.util.ArrayList;
import java.util.List;

import src.payment.Payment;

public class Hourly extends Employee {

    List<TimeCard> timecard;

    public Hourly(String name, int id, String address, UnionMember unionMember, Payment payment, int employeeType,
            String paymentDay, int hourSalary) {
        super(name, id, address, unionMember, payment, employeeType, paymentDay);
        timecard = new ArrayList<TimeCard>();
    }

    public List<TimeCard> getTimecard() {
        return timecard;
    }

    public void setTimecard(List<TimeCard> timecard) {
        this.timecard = timecard;
    }
}

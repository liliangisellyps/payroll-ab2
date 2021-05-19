package src.employees;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeCard {
    private LocalTime checkIn;
    private LocalTime checkOut;
    private LocalDate date;
    
    public TimeCard(LocalTime checkIn, LocalTime checkOut, LocalDate date) {
        this.setCheckIn(checkIn);
        this.setCheckOut(checkOut);
        this.setDate(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }
}

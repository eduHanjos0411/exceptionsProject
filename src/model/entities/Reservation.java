package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private final Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
        this.roomNumber = roomNumber;
        this.checkOut = checkOut;
        this.checkIn = checkIn;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: " +
                "Room: " + roomNumber +
                ", check-in: " + sdf.format(checkIn) +
                ", check-out: " + sdf.format(checkOut) +
                ", " + duration() +
                " nights";

    }
}

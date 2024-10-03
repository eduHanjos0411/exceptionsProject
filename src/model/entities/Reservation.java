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
    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates";
        } if (!checkOut.after(checkIn)){
            return "Check-out must be after check-in date";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
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

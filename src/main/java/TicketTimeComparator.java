import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int time1;
        int time2;

        if (t1.getTimeTo() > t1.getTimeFrom()) {
            time1 = t1.getTimeTo() - t1.getTimeFrom();
        } else {time1 = t1.getTimeTo() - t1.getTimeFrom() + 24;}
        if (t2.getTimeTo() > t2.getTimeFrom()) {
            time2 = t2.getTimeTo() - t2.getTimeFrom();
        } else {time2 = t2.getTimeTo() - t2.getTimeFrom() + 24;}

        if (time1 < time2) {
            return -1;
        } else if (time1 > time2) {
            return 1;
        } else {
            return 0;
        }
    }
}

import java.util.Comparator;

public class TickitComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o2.getTimeInMinutes() - o1.getTimeInMinutes();
    }
}
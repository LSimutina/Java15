import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketManager {
    private Repository repo;

    public TicketManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket product) {
        repo.save(product);
    }

    // Поиск товаров
    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result продукт product
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
            return true;
        }
        return false;
    }
}

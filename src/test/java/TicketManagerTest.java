import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 800, "MSK", "SBP", 60); //москва-питер
    Ticket ticket2 = new Ticket(2, 200, "SPB", "MSK", 50); //питер-москва
    Ticket ticket3 = new Ticket(3, 1_050, "MSK", "SMR", 20); //москва-самара
    Ticket ticket4 = new Ticket(4, 400, "MSK", "SBP", 70); //москва-питер
    Ticket ticket5 = new Ticket(5, 700, "MSK", "SBP", 65); //москва-питер
    Ticket ticket6 = new Ticket(6, 1_600, "SMR", "SBP", 45); //самара-питер
    Ticket ticket7 = new Ticket(7, 1_200, "NIN", "SMR", 70); //нижний-самара
    Ticket ticket8 = new Ticket(8, 2_000, "MSK", "NIN", 60); //москва-нижний
    Ticket ticket9 = new Ticket(9, 350, "MSK", "SBP", 60); //москва-питер
    Ticket ticket10 = new Ticket(10, 800, "NIN", "SMR", 65); //нижний-самара
    Ticket ticket11 = new Ticket(11, 100, "MSK", "NIN", 65); // москва-нижний
    Ticket ticket12 = new Ticket(12, 400, "NIN", "SBP", 80); //нижний-питер
    Ticket ticket13 = new Ticket(13, 350, "MSK", "SBP", 60); //москва-питер

    @Test // Проверка отсортированых билетов от МСК до СБП
    public void testSortTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);

        Ticket[] expected = {ticket9, ticket13, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MSK", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от МСК до СБП (если массив отсортирован по увеличению цены)
    public void testSortTrueTicket() {
        manager.add(ticket11);
        manager.add(ticket2);
        manager.add(ticket9);
        manager.add(ticket13);
        manager.add(ticket4);
        manager.add(ticket12);
        manager.add(ticket5);
        manager.add(ticket1);
        manager.add(ticket10);
        manager.add(ticket3);
        manager.add(ticket7);
        manager.add(ticket6);
        manager.add(ticket8);

        Ticket[] expected = {ticket9, ticket13, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MSK", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от МСК до СБП (если массив отсортирован по уменьшению цены)
    public void testSortFalseTicket() {
        manager.add(ticket8);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket3);
        manager.add(ticket10);
        manager.add(ticket1);
        manager.add(ticket5);
        manager.add(ticket12);
        manager.add(ticket4);
        manager.add(ticket13);
        manager.add(ticket9);
        manager.add(ticket2);
        manager.add(ticket11);

        Ticket[] expected = {ticket13, ticket9, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MSK", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }
}

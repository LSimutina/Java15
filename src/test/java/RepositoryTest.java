import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();

    Ticket ticket1 = new Ticket(1, 800, "MSK", "SBP", 60); //москва-питер
    Ticket ticket2 = new Ticket(2, 200, "SPB", "MSK", 50); //питер-москва
    Ticket ticket3 = new Ticket(3, 1_050, "MSK", "SMR", 20); //москва-самара
    Ticket ticket4 = new Ticket(4, 400, "MSK", "SBP", 70); //москва-питер
    Ticket ticket5 = new Ticket(5, 700, "MSK", "SBP", 65); //москва-питер
    Ticket ticket6 = new Ticket(6, 1_600, "SMR", "SBP", 45); //самара-питер
    Ticket ticket7 = new Ticket(7, 1_200, "NIN", "SMR", 70); //нижний-самара

    @Test
    public void shouldAddTicket() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTicketNull() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.removeById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}

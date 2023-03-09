import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 200, "GSV", "DME", 360);
    Ticket ticket2 = new Ticket(2, 150, "GSV", "VKO", 240);
    Ticket ticket3 = new Ticket(3, 200, "GSV", "DME", 360);
    Ticket ticket4 = new Ticket(4, 100, "GSV", "VKO", 240);
    Ticket ticket5 = new Ticket(5, 1000, "EVN", "INA", 600);
    Ticket ticket6 = new Ticket(6, 600, "ESL", "YKS", 660);

    @BeforeEach
    public void Ticket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }


    @Test
    void testAddTicket() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.getAllTickets();
        assertArrayEquals(expected, actual);
    }
    @Test
    void removeTicketById() {
        repository.removeTicketById(5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket6};
        Ticket[] actual = repository.getAllTickets();
        assertArrayEquals(expected, actual);
    }
}

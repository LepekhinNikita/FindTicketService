import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 200, "GSV", "DME", 360);
    Ticket ticket2 = new Ticket(2, 150, "GSV", "VKO", 240);
    Ticket ticket3 = new Ticket(3, 200, "GSV", "DME", 360);
    Ticket ticket4 = new Ticket(4, 100, "GSV", "VKO", 240);
    Ticket ticket5 = new Ticket(5, 1000, "EVN", "INA", 600);
    Ticket ticket6 = new Ticket(6, 600, "ESL", "YKS", 660);
    Ticket ticket7 = new Ticket(7,700, "ESL", "YKS", 660);


    @BeforeEach
    public void Ticket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

    }

    @Test
    public void testAddTicket() {


        Ticket[] actual = manager.getTickets();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByDepartureArrivalOneFound() {

        Ticket[] actual = manager.findAll("EVN", "INA");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByDepartureArrival() {

        Ticket[] actual = manager.findAll("ESL", "YKS");
        Ticket[] expected = {ticket6, ticket7};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByDepartureArrivalFirstLowThanSecond() {

        Ticket[] actual = manager.findAll("GSV", "VKO");
        Ticket[] expected = {ticket4, ticket2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByDepartureArrivalNoFound() {

        Ticket[] actual = manager.findAll("DSK", "DPT");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

//    @Test
//    void testShouldSearchByDepartureArrivalFourFound() {
//
//        Ticket[] actual = manager.searchBy("VIE", "TLV");
//        Ticket[] expected = {ticket2, ticket1, ticket8, ticket9};
//        Assertions.assertArrayEquals(expected, actual);
//    }



    @Test
    void testSearchByDepartureArrivalEqualPrice() {


        Ticket[] actual = manager.findAll("GSV", "DME");
        Ticket[] expected = {ticket1, ticket3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchMatchesArrivalFound() {

        boolean actual = manager.matchesArrival(ticket3, "DME");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchMatchesArrivalNotFound() {

        boolean actual = manager.matchesArrival(ticket3, "DPT");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchMatchesDepartureFound() {
        boolean actual = manager.matchesDeparture(ticket6, "ESL");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testSearchMatchesDepartureNotFound() {
        boolean actual = manager.matchesDeparture(ticket6, "DME");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

}
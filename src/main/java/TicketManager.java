import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public Ticket[] getTickets() {
        Ticket[] all = repo.getAllTickets();
        return all;
    }


    public Ticket[] findAll(String text1, String text2) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAllTickets()) {
            if (matchesDeparture(ticket, text1) && matchesArrival(ticket, text2)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }

        return result;

    }
//    public Ticket[] findAll(String text1, String text2) {
//        Ticket[] result = new Ticket[0];
//        for (Ticket ticket : repo.getAllTickets()) {
//            if (matchesDeparture(ticket, text1) && matchesArrival(ticket, text2)) {
//                Ticket[] tmp = new Ticket[result.length + 1];
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];
//                }
//                tmp[tmp.length - 1] = ticket;
//                result = tmp;
//                Arrays.sort(result);
//            }
//        }
//
//        return result;
//
//    }


    public boolean matchesArrival(Ticket ticket, String search) {
        if (ticket.getAirportArrival().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesDeparture(Ticket ticket, String search) {
        if (ticket.getAirportDeparture().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
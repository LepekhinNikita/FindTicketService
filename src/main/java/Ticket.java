public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String airportDeparture;
    protected String airportArrival;
    protected int tripTime;

    public int getId() {
        return id;
    }
       public String getAirportDeparture() {
        return airportDeparture;
    }
    public String getAirportArrival() {
        return airportArrival;
    }

    public Ticket(int id, int price, String airportDeparture, String airportArrival, int tripTime) {
        this.id = id;
        this.price = price;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.tripTime = tripTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
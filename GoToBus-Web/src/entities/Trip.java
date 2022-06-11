package entities;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;


@Stateless
@LocalBean
@Entity
public class Trip implements Serializable {

    @ManyToMany(mappedBy="trips",fetch=FetchType.EAGER)
    private Set <Station> stations;

    @ManyToMany(mappedBy="trips",fetch=FetchType.EAGER)
    private Set <User> users;
   
//    public Set<User> getUsers() {
//        return users;
//    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }
    public void addUser(User u) {
        this.users.add(u);
    }

    private String from_station;
    private String to_station;
    private int available_seats;
    private static final long serialVersionUID=1L;
    private String departure_time;
    private String arrival_time;
    private String from_date;
    private String to_date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   


}
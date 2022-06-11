package entities;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Stateless
@LocalBean
@Entity
public class User implements Serializable{
   
    private String password;
    private String full_name;
    private String role;
    public boolean isLoggedIn;
    private static final long serialVersionUID=1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="UserTrip",
            joinColumns= @JoinColumn(name="userId"),
            inverseJoinColumns= @JoinColumn(name="tripId"))
    private Set <Trip> trips;
   
    @OneToMany(mappedBy="user",fetch=FetchType.EAGER)
    private Set <Notifications> ns;
   
    public Set<Notifications> getNs() {
        return ns;
    }
    public void setNs(Set<Notifications> ns) {
        this.ns = ns;
    }
    public Set<Trip> getTrips() {
        return trips;
    }
    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void addTrip(Trip t) {
        this.trips.add(t);
    }
    public void addNotifications(Notifications n) {
        this.ns.add(n);
    }
   
}
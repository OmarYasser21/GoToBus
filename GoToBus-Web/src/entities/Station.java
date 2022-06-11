package entities;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Stateless
@LocalBean
@Entity
public class Station implements Serializable {
    private String name;
    private double longitude;
    private double latitude;
    private static final long serialVersionUID=1L;
   
    @ManyToMany
    @JoinTable(
            name="StationXTrip",
            joinColumns= @JoinColumn(name="StationId"),
            inverseJoinColumns= @JoinColumn(name="TripId"))
    private Set <Trip> trips;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
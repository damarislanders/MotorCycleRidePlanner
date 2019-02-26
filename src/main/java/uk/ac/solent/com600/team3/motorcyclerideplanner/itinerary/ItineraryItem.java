package uk.ac.solent.com600.team3.motorcyclerideplanner.itinerary;

import org.springframework.lang.Nullable;
import uk.ac.solent.com600.team3.motorcyclerideplanner.rideout.Rideout;

import javax.persistence.*;

@Entity
public class ItineraryItem {
    @Id
    @GeneratedValue
    @Nullable
    private Long id;

    private String name;
    @Lob private String description;
    private String address;
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rideout rideout;

    protected ItineraryItem() {}

    public ItineraryItem(String name, String description, String address, Type type, Rideout rideout) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.type = type;
        this.rideout = rideout;
    }

    // region Getters, setters
    @Nullable public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Rideout getRideout() {
        return rideout;
    }

    public void setRideout(Rideout rideout) {
        this.rideout = rideout;
    }
    // endregion

    public enum Type {
        ACCOMMODATION,
        STOP,
    }
}

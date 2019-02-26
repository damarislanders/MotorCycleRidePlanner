package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.springframework.lang.Nullable;
import uk.ac.solent.com600.team3.motorcyclerideplanner.itinerary.ItineraryItem;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Rideout {
    @Id
    @GeneratedValue
    @Nullable
    private Long id;

    @Lob private String description;
    private int maxRiders;
    private State state;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rideout")
    private List<ItineraryItem> itinerary;

    protected Rideout() {}

    public Rideout(String description, int maxRiders, State state, List<ItineraryItem> itinerary) {
        this.description = description;
        this.maxRiders = maxRiders;
        this.state = state;
        this.itinerary = itinerary;
    }

    // region Equals, hash code
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rideout)) return false;
        var rideout = (Rideout) o;
        return maxRiders == rideout.maxRiders &&
                Objects.equals(description, rideout.description) &&
                state == rideout.state;
    }

    @Override public int hashCode() {
        return Objects.hash(description, maxRiders, state);
    }
    // endregion

    // region Getters, setters
    @Nullable public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<ItineraryItem> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<ItineraryItem> itinerary) {
        this.itinerary = itinerary;
    }
    // endregion

    public enum State {
        DRAFT,
        PUBLISHED,
    }
}

package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.springframework.stereotype.Service;
import uk.ac.solent.com600.team3.motorcyclerideplanner.itinerary.ItineraryItem;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RideoutService {
    private final RideoutRepository repository;

    public RideoutService(RideoutRepository repository) {
        this.repository = repository;
    }

    public Optional<Rideout> rideout(Long id) {
        return repository.findById(id);
    }

    public Iterable<Rideout> rideouts() {
        ArrayList<ItineraryItem> itinerary = new ArrayList<>();
        Rideout rideout = new Rideout("Rideout description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed turpis augue. Nunc vulputate ex in lobortis " +
                "ultrices. Nunc fringilla, sapien non facilisis vulputate, turpis neque pellentesque nulla, vitae tincidunt metus " +
                "nunc a urna. Vivamus aliquet risus sem. Donec a arcu placerat ex ullamcorper porta. Donec laoreet viverra nunc " +
                "mollis condimentum. Etiam ex sapien, dapibus eget tempus ac, cursus eu justo. Maecenas maximus vitae arcu quis " +
                "facilisis. Ut cursus interdum nulla. Maecenas sit amet malesuada leo.", 5, Rideout.State.DRAFT, itinerary);
        itinerary.add(new ItineraryItem("Test", "First description here Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed turpis augue. Nunc vulputate ex in lobortis " +
                "ultrices. Nunc fringilla, sapien non facilisis vulputate, turpis neque pellentesque nulla, vitae tincidunt metus " +
                "nunc a urna. Vivamus aliquet risus sem. Donec a arcu placerat ex ullamcorper porta. Donec laoreet viverra nunc " +
                "mollis condimentum. Etiam ex sapien, dapibus eget tempus ac, cursus eu justo. Maecenas maximus vitae arcu quis " +
                "facilisis. Ut cursus interdum nulla. Maecenas sit amet malesuada leo.",
                "Address goes here", ItineraryItem.Type.ACCOMMODATION, rideout));
        itinerary.add(new ItineraryItem("Test", "Some description here Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed turpis augue. Nunc vulputate ex in lobortis " +
                "ultrices. Nunc fringilla, sapien non facilisis vulputate, turpis neque pellentesque nulla, vitae tincidunt metus " +
                "nunc a urna. Vivamus aliquet risus sem. Donec a arcu placerat ex ullamcorper porta. Donec laoreet viverra nunc " +
                "mollis condimentum. Etiam ex sapien, dapibus eget tempus ac, cursus eu justo. Maecenas maximus vitae arcu quis " +
                "facilisis. Ut cursus interdum nulla. Maecenas sit amet malesuada leo.",
                "Address goes here", ItineraryItem.Type.STOP, rideout));
        itinerary.add(new ItineraryItem("Test", "Some description here Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed turpis augue. Nunc vulputate ex in lobortis " +
                "ultrices. Nunc fringilla, sapien non facilisis vulputate, turpis neque pellentesque nulla, vitae tincidunt metus " +
                "nunc a urna. Vivamus aliquet risus sem. Donec a arcu placerat ex ullamcorper porta. Donec laoreet viverra nunc " +
                "mollis condimentum. Etiam ex sapien, dapibus eget tempus ac, cursus eu justo. Maecenas maximus vitae arcu quis " +
                "facilisis. Ut cursus interdum nulla. Maecenas sit amet malesuada leo.",
                "Address goes here", ItineraryItem.Type.STOP, rideout));
        itinerary.add(new ItineraryItem("Test", "Last description here Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed turpis augue. Nunc vulputate ex in lobortis " +
                "ultrices. Nunc fringilla, sapien non facilisis vulputate, turpis neque pellentesque nulla, vitae tincidunt metus " +
                "nunc a urna. Vivamus aliquet risus sem. Donec a arcu placerat ex ullamcorper porta. Donec laoreet viverra nunc " +
                "mollis condimentum. Etiam ex sapien, dapibus eget tempus ac, cursus eu justo. Maecenas maximus vitae arcu quis " +
                "facilisis. Ut cursus interdum nulla. Maecenas sit amet malesuada leo.",
                "Address goes here", ItineraryItem.Type.ACCOMMODATION, rideout));
        return repository.findAll();
    }

    public void edit(Rideout rideout) {
        repository.save(rideout);
    }
}

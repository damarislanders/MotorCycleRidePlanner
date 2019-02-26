package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.springframework.stereotype.Service;

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
        return repository.findAll();
    }

    public void edit(Rideout rideout) {
        repository.save(rideout);
    }
}

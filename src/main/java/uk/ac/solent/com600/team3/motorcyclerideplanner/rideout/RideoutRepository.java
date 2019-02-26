package uk.ac.solent.com600.team3.motorcyclerideplanner.rideout;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RideoutRepository extends CrudRepository<Rideout, Long> {
    List<Rideout> findByState(Rideout.State state);
}

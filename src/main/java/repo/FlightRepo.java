package repo;

import model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public class FlightRepo implements JpaRepository<Flight, Integer> {

}

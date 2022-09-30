package repo;

import model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class FlightRepo implements JpaRepository<Flight, Integer> {


}

package api;

import model.Seat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/seat")
public class SeatController {

    @GetMapping(value = "/{flightId}")
    public List<Seat>getAllSeats(String flightId){
        return null;
    }

    @GetMapping(value = "/{flightId}/{place}")
    public Seat getSeatByPlace(String flightId, String place){
        return null;
    }

    @PostMapping(value = "/{flightId}/{place}/{name}")
    public int addSeat(String flightId, String place, String name) {
        return 1;
    }

    @PostMapping(value = "/{flightId}/{place}")
    public int delSeat(String flightId, String place) {
        return 1;
    }

    @PostMapping(value = "/{flightId}/{place}/{name}")
    public int updateFlight(String flightId, String place, String name) {
        return 1;
    }






//    @PostMapping(value = "/book/{place}")
//    public String book(String place) {
//        return "seat";
//    }
}

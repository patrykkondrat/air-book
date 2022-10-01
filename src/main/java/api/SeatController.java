package api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/seat")
public class SeatController {

    @GetMapping
    public String getAll(){
        return "ok";
    }

//    @PostMapping(value = "/book/{place}")
//    public String book(String place) {
//        return "seat";
//    }
}

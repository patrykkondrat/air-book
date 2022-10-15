package com.airbook.app.repo;

import com.airbook.app.model.SeatPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatPlacementRepo extends JpaRepository<SeatPlacement, Long> {
}

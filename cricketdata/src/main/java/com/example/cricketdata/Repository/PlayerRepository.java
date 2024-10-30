package com.example.cricketdata.Repository;



import com.example.cricketdata.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "SELECT * FROM players ORDER BY runs DESC LIMIT 10", nativeQuery = true)
    List<Player> findTop10Players();

    @Query(value = "SELECT name, SUM(runs) as totalRuns FROM players WHERE name LIKE %?1% GROUP BY name", nativeQuery = true)
    List<Object[]> searchPlayersByName(String name);
}

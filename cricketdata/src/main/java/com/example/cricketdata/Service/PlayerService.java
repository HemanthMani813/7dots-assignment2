package com.example.cricketdata.Service;

import com.example.cricketdata.model.Player;

import com.example.cricketdata.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getTopPlayers() {
        return playerRepository.findTop10Players();
    }

    public Map<String, Integer> searchPlayers(String name) {
        List<Object[]> results = playerRepository.searchPlayersByName(name);
        Map<String, Integer> playerRuns = new HashMap<>();
        for (Object[] result : results) {
            String playerName = (String) result[0];
            Integer totalRuns = ((Number) result[1]).intValue();
            playerRuns.put(playerName, totalRuns);
        }
        return playerRuns;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }


}

package com.example.cricketdata.Controller;



import com.example.cricketdata.model.Player;
import com.example.cricketdata.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Player>> getTopPlayers() {
        return new ResponseEntity<>(playerService.getTopPlayers(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Integer>> searchPlayers(@RequestParam String name) {
        return new ResponseEntity<>(playerService.searchPlayers(name), HttpStatus.OK);
    }

    // 4th api :get all data
    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    //5th api: delete player
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return "Player deleted successfully!";
    }

}

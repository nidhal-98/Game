package com.springpirates.stolengameapi.controllers;

import com.springpirates.stolengameapi.models.Player;
import com.springpirates.stolengameapi.services.PlayerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(path = "/getAll")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(path = "/getPlayer/{id}")
    public Player getSpecificPlayer(@PathVariable(name = "id") String id) {
        Player playerFound = null;
        if (Strings.isNotBlank(id)){
            playerFound = playerService.getSpecificPlayer(id);
        }
        return playerFound;
    }

    @PostMapping(path = "/add")
    public Player createPlayer(@RequestBody Player incomingPlayer) {
        return playerService.createPlayer(incomingPlayer);
    }

    @PutMapping(path = "/update/{id}")
    public Player updatePlayer(@PathVariable(name = "id") String id, @RequestBody Player incomingUpdatedPlayer) {
        return playerService.updatePlayer(id, incomingUpdatedPlayer);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Player deletePlayer(@PathVariable(name = "id") String id) {
        return playerService.deletePlayer(id);
    }
}

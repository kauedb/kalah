package br.com.kauedb.games.kalah.view;

import br.com.kauedb.games.kalah.domain.Board;
import br.com.kauedb.games.kalah.domain.Player;
import br.com.kauedb.games.kalah.domain.Players;
import br.com.kauedb.games.kalah.view.resources.MovementResource;
import br.com.kauedb.games.kalah.view.resources.PlayerResource;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 */
@RestController
@RequestMapping("/boards")
public class BoardEndpoints {

    private Board board = Board.builder().players(new Players()).build();

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
    public HttpEntity<PlayerResource> get(@PathVariable Integer id){
        val player = board.getPlayers().getById(id);
        return new ResponseEntity<>(new PlayerResource(player), HttpStatus.OK);
    }

    @RequestMapping(value = "/players/{id}/movements", method = RequestMethod.POST)
    public HttpEntity<MovementResource> move(@PathVariable Integer id, @RequestBody final MovementResource movementResource) {
        val player = board.getPlayers().getById(id);
        player.move().sows(movementResource.getQuantity())
                .from().pit(movementResource.getFrom())
                .to().pit(movementResource.getTo());
        return new ResponseEntity<>(movementResource, HttpStatus.CREATED);
    }

    

}

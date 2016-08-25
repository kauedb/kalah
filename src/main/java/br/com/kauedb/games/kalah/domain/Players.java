package br.com.kauedb.games.kalah.domain;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Players {

    List<Player> players;

    public Players() {
        players = Arrays.asList(
                Player.builder().id(1).build(),
                Player.builder().id(2).build()
        );
    }

    public Player getById(final Integer id) {
        return players.get(id - 1);
    }
}

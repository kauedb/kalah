package br.com.kauedb.games.kalah.domain;

import com.google.common.eventbus.EventBus;
import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Value
@Builder
public class Players {

    List<Player> players;

    public Players() {
        players = Arrays.asList(
                Player.builder().id(1).build(),
                Player.builder().id(2).build()
        );
    }

    public Players(final List<Player> players) {
        this.players = players;
    }

    public Player getById(final Integer id) {
        return players.get(id - 1);
    }
}

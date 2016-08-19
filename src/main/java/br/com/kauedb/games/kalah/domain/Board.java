package br.com.kauedb.games.kalah.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
@Value
@Builder
public class Board {

    List<Player> players = Arrays.asList(
            Player.builder().id(1).build(),
            Player.builder().id(2).build()
    );

}

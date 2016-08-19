package br.com.kauedb.games.kalah.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 */
public class PlayerMoveTest {

    Player player;

    @Before
    public void setup(){
        player = Player.builder().id(1).build();
    }

    @Test
    public void shouldMoveFromOnePitToAnother(){

        player.move().sows(6).from().pit(1).to().pit(2);
        assertThat(player.getPits().get(1).getSows().getQuantity(), is(0));
        assertThat(player.getPits().get(2).getSows().getQuantity(), is(12));

    }
}

package br.com.kauedb.games.kalah.domain;

import br.com.kauedb.games.kalah.exception.InvalidMoveException;
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

    @Test(expected = InvalidMoveException.class)
    public void shouldNotMoveFromOnePitToPitBehind(){
        player.move().sows(6).from().pit(2).to().pit(1);
    }
}

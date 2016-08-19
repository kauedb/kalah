package br.com.kauedb.games.kalah.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 */
public class SowsRemoveTest extends AbstractSowsOperationsTest {

    @Test
    public void shouldRemove1Sow(){
        sows.remove(6);

        assertThat(sows.getQuantity(), is(0));
    }

}

package br.com.kauedb.games.kalah.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 */
public class SowsAddTest extends AbstractSowsOperationsTest {

    @Test
    public void shouldAdd1() {
        sows.add(1);

        assertThat(sows.getQuantity(), is(7));
    }
}

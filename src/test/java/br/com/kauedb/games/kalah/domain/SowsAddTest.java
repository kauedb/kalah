package br.com.kauedb.games.kalah.domain;

import com.google.common.eventbus.Subscribe;
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


    static class A {
        @Subscribe
        public void m(){

        }
    }

    static class B {

        public void m(){

        }
    }

    @Test
    public void should(){

    }

}

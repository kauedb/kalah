package br.com.kauedb.games.kalah.domain;

import org.junit.Before;

/**
 */
public abstract class AbstractSowsOperationsTest {

    Sows sows;

    @Before
    public void setup(){
        sows = Sows.builder().quantity(6).build();
    }


}

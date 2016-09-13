package br.com.kauedb.games.kalah.domain;

import br.com.kauedb.games.kalah.exception.GameHasEndedException;
import br.com.kauedb.games.kalah.exception.InvalidMoveException;
import com.google.common.eventbus.EventBus;
import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Value
@Builder
public class Player {

    Integer id;

    House house = House.houseBuilder().build();

    List<Pit> pits = Arrays.asList(
            Pit.builder().sows(Sows.builder().quantity(6).build()).build(),
            Pit.builder().sows(Sows.builder().quantity(6).build()).build(),
            Pit.builder().sows(Sows.builder().quantity(6).build()).build(),
            Pit.builder().sows(Sows.builder().quantity(6).build()).build(),
            Pit.builder().sows(Sows.builder().quantity(6).build()).build(),
            Pit.builder().sows(Sows.builder().quantity(6).build()).build()
    );

    private void hasGameEnded(){
        final List<Pit> sowedPits = pits.stream().filter(pit -> pit.getSows().getQuantity() > 0).collect(Collectors.toList());
        if(!sowedPits.isEmpty()){
            throw new GameHasEndedException();
        }
    }

    public MoveBuilder move() {
        hasGameEnded();
        return new MoveBuilder();
    }

    public class MoveBuilder {
        public SowsBuilder sows(final int quantity) {
            return new SowsBuilder(quantity);
        }
    }

    public class SowsBuilder {
        private final int quantity;

        public SowsBuilder(int quantity) {
            this.quantity = quantity;
        }

        public FromBuilder from() {
            return new FromBuilder(quantity);
        }
    }

    public class From {
        private final int quantity;
        private final int index;

        public From(int quantity, int index) {
            this.quantity = quantity;
            this.index = index;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getIndex() {
            return index;
        }
    }

    public class FromBuilder {
        private final int quantity;

        public FromBuilder(final int quantity) {
            this.quantity = quantity;
        }

        public ToConnectorBuilder pit(final Integer index) {
            return new ToConnectorBuilder(new From(quantity, index));
        }

    }

    public class ToConnectorBuilder {

        private final From from;

        public ToConnectorBuilder(final From from) {
            this.from = from;
        }

        public ToBuilder to() {
            return new ToBuilder(from);
        }
    }

    public class ToBuilder {
        private final From from;

        public ToBuilder(From from) {
            this.from = from;
        }

        public MoveConnectorBuilder pit(Integer index) {
            createMovement(index);
            return new MoveConnectorBuilder();
        }

        private void createMovement(Integer index) {
            if(from.getIndex() >= index){
                throw new InvalidMoveException();
            }

            pits.get(from.getIndex()).getSows().remove(from.getQuantity());
            pits.get(index).getSows().add(from.getQuantity());
        }
    }

    public class MoveConnectorBuilder {
        public MoveBuilder move() {
            return new MoveBuilder();
        }
    }
}

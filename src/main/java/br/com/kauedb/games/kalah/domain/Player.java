package br.com.kauedb.games.kalah.domain;

import br.com.kauedb.games.kalah.exception.InvalidMoveException;
import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

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

    public MoveBuilder move() {
        return new MoveBuilder();
    }

    public class MoveBuilder {
        public SowsBuilder sows(final Integer quantity) {
            return new SowsBuilder(6);
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

        public FromBuilder(int quantity) {
            this.quantity = quantity;
        }

        public ToConnectorBuilder pit(Integer index) {
            return new ToConnectorBuilder(new From(quantity, index));
        }

    }

    public class ToConnectorBuilder {

        private final From from;

        public ToConnectorBuilder(From from) {
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
            if(from.getIndex() >= index){
                throw new InvalidMoveException();
            }

            pits.get(from.getIndex()).getSows().remove(from.getQuantity());
            pits.get(index).getSows().add(from.getQuantity());
            return new MoveConnectorBuilder();
        }
    }

    public class MoveConnectorBuilder {
        public MoveBuilder move() {
            return new MoveBuilder();
        }
    }
}

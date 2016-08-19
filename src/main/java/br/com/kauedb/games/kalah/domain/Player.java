package br.com.kauedb.games.kalah.domain;

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

    public class FromBuilder {

        private final int quantity;

        public FromBuilder(int quantity) {
            this.quantity = quantity;
        }

        public ToConnectorBuilder pit(Integer index) {
             pits.get(index).getSows().remove(quantity);
            return new ToConnectorBuilder(quantity);
        }

    }

    public class ToConnectorBuilder {

        private final int quantity;

        public ToConnectorBuilder(int quantity) {
            this.quantity = quantity;
        }

        public ToBuilder to() {
            return new ToBuilder(quantity);
        }
    }

    public class ToBuilder {
        private final int quantity;

        public ToBuilder(int quantity) {
            this.quantity = quantity;
        }

        public MoveConnectorBuilder pit(Integer index) {
            pits.get(index).getSows().add(quantity);
            return new MoveConnectorBuilder();
        }
    }

    public class MoveConnectorBuilder {
        public MoveBuilder move() {
            return new MoveBuilder();
        }
    }
}

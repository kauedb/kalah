package br.com.kauedb.games.kalah.domain;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@Builder
public class Sows {

    @NonFinal
    Integer quantity;

    public Sows add(Integer quantity) {
        this.quantity = this.quantity + quantity;
        return this;
    }

    public Sows remove(Integer quantity) {
        this.quantity = this.quantity - quantity;
        return this;
    }
}

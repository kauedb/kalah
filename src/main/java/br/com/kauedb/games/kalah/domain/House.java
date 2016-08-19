package br.com.kauedb.games.kalah.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class House extends Pit {

    @Builder(builderMethodName = "houseBuilder")
    public House(Sows sows) {
        super(sows);
    }
}

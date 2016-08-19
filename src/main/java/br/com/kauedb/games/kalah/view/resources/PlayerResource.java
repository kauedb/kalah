package br.com.kauedb.games.kalah.view.resources;

import br.com.kauedb.games.kalah.domain.Player;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 */
@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerResource extends ResourceSupport {

    Integer number;

    public PlayerResource(Player player){
        this.number = player.getId();
    }

}

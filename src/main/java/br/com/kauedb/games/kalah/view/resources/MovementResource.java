package br.com.kauedb.games.kalah.view.resources;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;

/**
 */
@Value
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MovementResource extends ResourceSupport {

    Integer from;
    Integer to;
    Integer quantity;
}

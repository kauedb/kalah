package br.com.kauedb.games.kalah.view;

import br.com.kauedb.games.kalah.view.resources.MovementResource;
import br.com.kauedb.games.kalah.view.resources.PlayerResource;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PlayerEndpointsTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldCreateMovement() {
        val request = new MovementResource(1, 2, 6);
        val entity = this.restTemplate.postForEntity("http://localhost:8080/players/1/movement", request, MovementResource.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(entity.getBody(), is(request));
    }

    @Test
    public void shouldGetPlayer() {
        val entity = this.restTemplate.getForEntity("http://localhost:8080/players/1", PlayerResource.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody(), is(new PlayerResource(1)));
    }

}

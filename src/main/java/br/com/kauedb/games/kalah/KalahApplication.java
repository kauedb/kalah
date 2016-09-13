package br.com.kauedb.games.kalah;

import br.com.kauedb.games.kalah.domain.Pit;
import com.google.common.eventbus.EventBus;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class KalahApplication {

	@Configuration
	public static class EventBusConfig {

		@Bean
		public EventBus eventBus(){
			val eventBus = new EventBus();
			return eventBus;
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(KalahApplication.class, args);
	}
}

package br.edu.uniritter.topi;

import br.edu.uniritter.topi.entity.Event;
import br.edu.uniritter.topi.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TopiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TopiApplication.class, args);
	}

	@Bean
	public CommandLineRunner example(EventRepository repository) {
		return (args) -> {
			System.out.println("Here we go!");
			repository.save(new Event(1L, "Example", new Date()));
			List<Event> events = repository.findByName("Example");
			System.out.println(repository.findAll());
			System.out.println(events);
		};
	}
}

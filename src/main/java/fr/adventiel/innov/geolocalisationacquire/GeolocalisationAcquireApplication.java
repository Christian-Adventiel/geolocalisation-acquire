package fr.adventiel.innov.geolocalisationacquire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GeolocalisationAcquireApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocalisationAcquireApplication.class, args);
	}

}

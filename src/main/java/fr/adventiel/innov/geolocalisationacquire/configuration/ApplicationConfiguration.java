package fr.adventiel.innov.geolocalisationacquire.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Anto on 02/05/19.
 */
@Configuration
public interface ApplicationConfiguration {

    /**
     * Return needed override rest template
     * @return see desc moron
     */
    RestTemplate restTemplate();
}

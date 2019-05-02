package fr.adventiel.innov.geolocalisationacquire.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("objenious")
public class ObjeniousConfiguration implements ApplicationConfiguration {

    /**
     * Objenious API Key.
     */
    @Value(value = "${objenious.apikey}")
    private String objeniousApiKey;

    /**
     * Add generic token header to RestTemplate.
     * @return see desc genius
     */
    @Bean
    @Override
    public RestTemplate restTemplate() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("objeniousApiKey", objeniousApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

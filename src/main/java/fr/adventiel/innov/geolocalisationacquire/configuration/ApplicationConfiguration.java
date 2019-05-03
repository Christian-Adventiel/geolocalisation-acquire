package fr.adventiel.innov.geolocalisationacquire.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfiguration {

    /**
     * Objenious API Key.
     */
    @Value(value = "${objenious.apikey}")
    private String objeniousApiKey;

    /**
     * Baliz API Key.
     */
    @Value(value = "${baliz.apikey}")
    private String balizApiKey;

    /**
     * Add generic token header to Baliz RestTemplate.
     *
     * @return
     */
    @Bean(name = "balizRestTemplate")
    public RestTemplate restTemplateBaliz() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("balizApiKey", balizApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    /**
     * Add generic token header to Objenious RestTemplate.
     *
     * @return see desc genius
     */
    @Bean(name = "objeniousRestTemplate")
    public RestTemplate restTemplateObjenious() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("objeniousApiKey", objeniousApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

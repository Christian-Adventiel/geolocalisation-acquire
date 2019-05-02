package fr.adventiel.innov.geolocalisationacquire.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anto on 02/05/19.
 */
@Service("baliz")
public class BalizConfiguration implements ApplicationConfiguration {

    /**
     * Baliz API Key.
     */
    @Value(value = "${baliz.balizApiKey}")
    private String balizApiKey;


    @Override
    public RestTemplate restTemplate() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("balizApiKey", balizApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

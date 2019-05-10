package fr.adventiel.innov.geolocalisationacquire.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
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
        interceptors.add(new HeaderRequestInterceptor("exotic-api-key", balizApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);

        // Make the restTemplate aware of any HTTP types because Exotic sends back text/plain content-type instead of application/json
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

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
        interceptors.add(new HeaderRequestInterceptor("apikey", objeniousApiKey));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

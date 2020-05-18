package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@ConfigurationProperties(prefix = "lds.beer",ignoreUnknownFields=false)
public class BeerOrderRestTemplateService {

    static final String BASE_URL="/api/v1/beerUpc/";
    RestTemplate restTemplate;

    String beerServiceHost;

    @Autowired
    void setRestTemplate(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setBeerServiceHost(String beerServiceHost){
        this.beerServiceHost = beerServiceHost;
    }

    public BeerDto getBeerByUpc(String upc){
        return restTemplate.getForObject(beerServiceHost+BASE_URL+upc,BeerDto.class);
    }
}
